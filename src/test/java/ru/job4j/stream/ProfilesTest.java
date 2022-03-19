package ru.job4j.stream;

import org.junit.Test;
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
}