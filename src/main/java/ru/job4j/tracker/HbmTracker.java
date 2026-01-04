package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(item);
                transaction.commit();
                return item;
            } catch (Exception e) {
                transaction.rollback();
                throw new RuntimeException("Failed to save item", e);
            }
        }
    }

    @Override
    public boolean replace(Integer id, Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                int deletedRows = session.
                        createQuery("UPDATE Item SET name = :newName WHERE id = :id")
                        .setParameter("newName", item.getName())
                        .setParameter("id", id).executeUpdate();
                transaction.commit();
                return deletedRows > 0;
            } catch (Exception e) {
                transaction.rollback();
                throw new RuntimeException("Failed to edit item", e);
            }
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                int updatedRows = session.createQuery("DELETE FROM Item WHERE id = :id")
                        .setParameter("id", id).executeUpdate();
                transaction.commit();
                return updatedRows > 0;
            } catch (Exception e) {
                transaction.rollback();
                throw new RuntimeException("Failed to delete item", e);
            }
        }
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Item ORDER by name", Item.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve from data base", e);
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Item WHERE name = :key", Item.class)
                    .setParameter("key", key).list();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve from data base", e);
        }
    }

    @Override
    public Item findById(Integer id) {
        try (Session session = sf.openSession()) {
            return session.get(Item.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve from data base", e);
        }
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
