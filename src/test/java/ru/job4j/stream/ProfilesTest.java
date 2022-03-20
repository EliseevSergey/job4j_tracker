package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenTestMethodCollect() {
        Adress first = new Adress("City1", "Street1", 1, 1);
        Adress second = new Adress("City2", "Street1", 2, 2);
        Adress third = new Adress("City3", "Street3", 3, 3);
        List<Profile> profiles = List.of(
                new Profile(first),
                new Profile(second),
                new Profile(third));
        List<Adress> exp = List.of(first, second, third);
        List<Adress> rsl = Profiles.collect(profiles);
        assertThat(exp, is(rsl));
    }

    @Test
    public void whenTestMethodCollectSortWithoutDuplicate() {
        Adress first = new Adress("City1", "Street1", 1, 1);
        Adress second = new Adress("City2", "Street2", 2, 2);
        Adress third = new Adress("City3", "Street3", 3, 3);
        Adress fourth = new Adress("City1", "Street1", 1, 1);
        Adress fifth = new Adress("City2", "Street2", 2, 2);
        Adress seventh = new Adress("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third));
        List<Adress> result = Profiles.collectSortWithoutDuplicate(profiles);
        List<Adress> expected = Arrays.asList(first, second, third);
        assertEquals(expected, result);
    }
}