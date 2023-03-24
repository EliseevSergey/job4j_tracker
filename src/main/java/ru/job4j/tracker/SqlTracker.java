package ru.job4j.tracker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement(
                "insert into items (name, creation_time) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, item.getName());
                ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
                ps.execute();
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        item.setId(generatedKeys.getInt(1));
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item in) {
        boolean rsl = false;
        try (PreparedStatement ps = cn.prepareStatement(
                "update items set name = (?) where id = (?)")) {
            ps.setString(1, in.getName());
            ps.setInt(2, id);
            rsl = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement ps = cn.prepareStatement(
                "delete from items where id = ?")) {
            ps.setInt(1, id);
            rsl = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List rsl = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            st.execute("select * from items");
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString(2));
                item.setId(resultSet.getInt(1));
                item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                rsl.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List rsl = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(
                "select * from items where name = ?")) {
            ps.setString(1, key);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getString(2));
                    item.setId(resultSet.getInt(1));
                    item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                    rsl.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try (PreparedStatement ps = cn.prepareStatement(
                "select * from items where id = ?")) {
                ps.setInt(1, id);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (resultSet.next()) {
                    rsl.setId(resultSet.getInt(1));
                    rsl.setName(resultSet.getString(2));
                    rsl.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
