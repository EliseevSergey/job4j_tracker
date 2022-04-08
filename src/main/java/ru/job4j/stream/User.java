package ru.job4j.stream;

public class User {
    private String name;
    private String surname;
    private int age;
    private boolean active;

    static class Builder {
        private String name;
        private String surname;
        private int age;
        private boolean active;

        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        public Builder buildActive(boolean activate) {
            this.active = activate;
            return this;
        }

        public User build() {
            User user = new User();
            user.name = name;
            user.surname = surname;
            user.age = age;
            user.active = active;
            return user;
        }
    }

    public static void main(String[] args) {
        User user = new Builder().buildName("name")
                .buildSurname("surname")
                .buildAge(32)
                .buildActive(true)
                .build();
        System.out.println(user);
    }

    @Override
    public String toString() {
        return "User{" + "name='"
                + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", active=" + active + '}';
    }
}

