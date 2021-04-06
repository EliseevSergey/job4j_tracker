package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() throws NoOneWasFoundException {
        PhoneDictionary musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        ArrayList<Person> result = musicians.find("urt");
        assertThat(result.get(0).getSurname(), is("Cobain"));
    }

    @Test
    public void whenFindBySurname() throws NoOneWasFoundException {
        PhoneDictionary musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        ArrayList<Person> result = musicians.find("oba");
        assertThat(result.get(0).getSurname(), is("Cobain"));
    }

    @Test
    public void whenFindByPhone() throws NoOneWasFoundException {
        PhoneDictionary musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        ArrayList<Person> result = musicians.find("666");
        assertThat(result.get(0).getAddress(), is("Voronezh"));
    }

    @Test
    public void whenFindByAddressTwo() throws NoOneWasFoundException {
        PhoneDictionary musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        musicians.add(new Person("David", "Gilmor", "333666", "Voronezh"));
        ArrayList<Person> result = musicians.find("orone");
        assertThat(result.get(1).getAddress(), is("Voronezh"));
    }

    @Test(expected = NoOneWasFoundException.class)
    public void whenException() throws NoOneWasFoundException {
        PhoneDictionary musicians = new PhoneDictionary();
        musicians.add(new Person("Curt", "Cobain", "666777", "Voronezh"));
        musicians.find("HardToFind");
    }
}