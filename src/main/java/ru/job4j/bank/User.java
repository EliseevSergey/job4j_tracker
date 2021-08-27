package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает обьект User - клиент банка.
 * назначает поля, getter & setter, переопределяет методы equals and hashCode
 * @author ELISEEV SERGEY
 * @version 1.0
 */

public class User {
    /**
     * Поля обьекта User:
     * 1) String passport - номер паспорта
     * 2) String username - фамилия
     * я бы вообще не писал про поля - это и так понятно должно быть
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
