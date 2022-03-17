package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameCheck = p -> p.getName().equals(key);
        Predicate<Person> surnameCheck = p -> p.getName().equals(key);
        Predicate<Person> phoneCheck = p -> p.getPhone().equals(key);
        Predicate<Person> adressCheck = p -> p.getAddress().equals(key);
        Predicate<Person> combine = nameCheck.or(surnameCheck.or(phoneCheck.or(adressCheck)));
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
