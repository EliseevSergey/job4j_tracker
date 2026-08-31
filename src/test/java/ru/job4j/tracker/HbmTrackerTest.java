package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {
    private static HbmTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new HbmTracker();
        clearAll();
    }

    @AfterEach
    public void shoutDown() throws Exception {
        tracker.close();
    }

    private void clearAll() {
        for (Item item : tracker.findAll()) {
            tracker.delete(item.getId());
        }
    }

    @Test
    public void whenAddThenFoundSameName() {
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenReplaceThenItemHasNewName() {
        Item itemBefore = new Item();
        itemBefore.setName("BEFORE");
        tracker.add(itemBefore);
        Item itemAfter = new Item();
        itemAfter.setName("AFTER");
        tracker.replace(itemBefore.getId(), itemAfter);
        Item replaced = tracker.findById(itemBefore.getId());
        assertThat(replaced.getName()).isEqualTo("AFTER");
    }

    @Test
    public void whenDeleteThenFoundNull() {
        Item item = new Item("toBeDeleted");
        tracker.add(item);
        int itemId = item.getId();
        assertThat(tracker.delete(item.getId())).isTrue();
        assertThat(tracker.findById(itemId)).isNull();
    }

    @Test
    public void whenFindAllThenFoundAll() {
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findAll()).isEqualTo(List.of(item1, item2, item3));
    }

    @Test
    public void whenFindByIdThenFoundItem() {
        Item item = new Item("first");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public  void whenFindByNonExistingIdThenNull() {
        assertThat(tracker.findById(9999)).isNull();
    }
}
