package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.*;

import javax.persistence.Query;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            /*bla bla with session*/

            Query query = session.createQuery(
                    "FROM Item AS i WHERE i.id = 8", Item.class);
            System.out.println(((org.hibernate.query.Query<?>) query).uniqueResult());
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

