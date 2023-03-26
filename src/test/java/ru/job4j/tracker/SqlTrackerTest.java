package ru.job4j.tracker;

import org.junit.jupiter.api.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item toBeReplaced = new Item("toBeReplaced");
        tracker.add(toBeReplaced);
        Item replacement = new Item("replacement");
        Assertions.assertTrue(tracker.replace(toBeReplaced.getId(), replacement));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item toBeDeleted = new Item("toBeDeleted");
        tracker.add(toBeDeleted);
        Assertions.assertTrue(tracker.delete(toBeDeleted.getId()));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        int id = tracker.add(new Item("theSameName")).getId();
        tracker.add(new Item("theSameName"));
        tracker.add(new Item("theSameName"));
        tracker.add(new Item("variousName"));
        List<Item> list = new ArrayList<>();
        list.add(tracker.findById(id));
        list.add(tracker.findById(id + 1));
        list.add(tracker.findById(id + 2));
        Assertions.assertEquals(list, tracker.findByName("theSameName"));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        int id = tracker.add(new Item("Item1")).getId();
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item3"));
        tracker.add(new Item("Item4"));
        List<Item> list = new ArrayList<>();
        list.add(tracker.findById(id));
        list.add(tracker.findById(id + 1));
        list.add(tracker.findById(id + 2));
        list.add(tracker.findById(id + 3));
        Assertions.assertEquals(list, tracker.findAll());
    }
}