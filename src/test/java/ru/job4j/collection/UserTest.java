package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenDif() {
        Set<User> users = new TreeSet<User>();
        users.add(new User(31, "Ivan"));
        users.add(new User(25, "Ivan"));
        users.add(new User(32, "Vasya"));
        users.add(new User(32, "Vova"));
        System.out.println(users);
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User(25, "Ivan")));
        assertThat(it.next(), is(new User(31, "Ivan")));
        assertThat(it.next(), is(new User(32, "Vasya")));
        assertThat(it.next(), is(new User(32, "Vova")));
    }

    @Test
    public void whenCompareUsers() {
        int rsl = new User(44, "Vasya").compareTo(new User(33, "Vova"));
        assertThat(rsl, lessThan(0)
        );
    }
}
