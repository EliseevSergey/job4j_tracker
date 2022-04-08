package ru.job4j.stream;

public class UserPool {
    public static void main(String[] args) {
        User user = new User.Builder()
                .buildName("Kolya")
                .buildSurname("Nikolaev")
                .buildAge(32)
                .buildActive(true)
                .build();

        System.out.println(user);
    }
}
