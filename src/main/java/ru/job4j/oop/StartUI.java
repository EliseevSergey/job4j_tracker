package ru.job4j.oop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item sample = new Item();
        System.out.println("текущая дата и время до форматирования : " + sample.getCreated());

        DateTimeFormatter style = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String reshaped = sample.getCreated().format(style);
        System.out.println("текущая дата и время после форматирования: " + reshaped);
    }
}
