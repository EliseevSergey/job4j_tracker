package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student shkolota = new Student();
        shkolota.setSurname("Ivanov");
        shkolota.setGroup("1019/2");
        System.out.println("Name: " + shkolota.getSurname() + " group: "
                + shkolota.getGroup() + " entrance: " + shkolota.getCreated());
    }
}
