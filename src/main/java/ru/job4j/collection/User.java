package ru.job4j.collection;

import java.util.Objects;


public class User implements Comparable<User> {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(User another) {
        if(!another.getName().equals(this.getName())) {
            return this.name.compareTo(another.getName());
        } else {
            return Integer.compare(this.age, another.age);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
