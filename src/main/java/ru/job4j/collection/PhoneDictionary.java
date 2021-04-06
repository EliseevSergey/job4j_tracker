package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> people = new ArrayList<>();

    public void add(Person person) {
        this.people.add(person);
    }

    public ArrayList<Person> find(String key) throws NoOneWasFoundException {
        ArrayList<Person> result = new ArrayList<>();
        for (int index = 0; index < people.size(); index++) {
            if (people.get(index).getName().contains(key)
                    || people.get(index).getSurname().contains(key)
                    || people.get(index).getAddress().contains(key)
                    || people.get(index).getPhone().contains(key)) {
                result.add(people.get(index));
            }
        }
        if (result.size() == 0) {
            throw new NoOneWasFoundException("No one was found");
        }
        return result;
    }
}
