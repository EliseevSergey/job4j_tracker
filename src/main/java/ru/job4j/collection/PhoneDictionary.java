package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> people = new ArrayList<>();

    public void add(Person person) {
        this.people.add(person);
    }

    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (Person person : people) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getAddress().contains(key)
                    || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
