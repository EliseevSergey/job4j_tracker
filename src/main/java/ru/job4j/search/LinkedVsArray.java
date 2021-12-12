package ru.job4j.search;

import java.util.*;

public class LinkedVsArray {
    public static void main(String[] args) {
        LinkedList<Person> adressBook = new LinkedList<Person>();
        Person person1 = new Person("Jeck", 31);
        Person person2 = new Person("Frog", 39);
        Person person3 = new Person("Virt", 39);
        Person greg = new Person("Greg", 9);
        adressBook.add(person1);
        adressBook.add(person2);
        adressBook.add(person3);
        ListIterator<Person> iterator = adressBook.listIterator();
        while (iterator.hasNext()) {
            iterator.add(greg);
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

