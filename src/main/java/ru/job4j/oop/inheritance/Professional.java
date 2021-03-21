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

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}