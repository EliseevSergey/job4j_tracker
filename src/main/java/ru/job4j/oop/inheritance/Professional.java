package ru.job4j.oop.inheritance;

public class Professional {
    private String name;
    private String surname;
    private String education;
    private String birthday;
    private int age;

    public Professional() {
    }

    public Professional(String name, String surname, String education, String birthday, int age) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public  String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }




}
