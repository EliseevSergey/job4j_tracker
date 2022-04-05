package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        ArrayList<Person> result = musicians.find("urt");
        assertThat(result.get(0).getSurname(), is("Cobain"));
    }

    @Test
    public void whenFindBySurname() {
        var musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        ArrayList<Person> result = musicians.find("oba");
        assertThat(result.get(0).getSurname(), is("Cobain"));
    }

    @Test
    public void whenFindByPhone() {
        var musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        ArrayList<Person> result = musicians.find("666");
        assertThat(result.get(0).getAddress(), is("Voronezh"));
    }

    @Test
    public void whenFindByAddressTwo() {
        var musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        musicians.add(new Person("David", "Gilmor", "333666", "Voronezh"));
        ArrayList<Person> result = musicians.find("orone");
        assertThat(result.get(1).getAddress(), is("Voronezh"));
    }

    @Test
    public void whenEmptyArrayList() {
        var musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        musicians.add(new Person("David", "Gilmor", "333666", "Voronezh"));
        ArrayList<Person> result = musicians.find("Saint-Petersburg");
        Assert.assertTrue(result.isEmpty());
    }
}