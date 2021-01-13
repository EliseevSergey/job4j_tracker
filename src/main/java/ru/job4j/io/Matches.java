package ru.job4j.io;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("-=Последний - Мёртвый=-");
        Scanner round = new Scanner(System.in);
        System.out.println("Введите имя первого игрока");
        String first = round.nextLine();
        System.out.println("Введите имя второго игрока");
        String second = round.nextLine();
        int decision = 0;
        int rest = 11;
        int shifter = 0;
        while (rest > 0) {
            System.out.println("Остаток спичек: " + rest);
            if (shifter == 0 || shifter % 2 == 0) {
                System.out.println(first + " Сделай свой ход");
                shifter++;
            } else {
                System.out.println(second + " Сделай свой ход");
                shifter++;
            }
            decision = Integer.valueOf(round.nextLine());
            if (decision > 3 || decision < 1) {
                System.out.println("Ну я же сказал, что от 1 до 3х спичек.");
                decision = 0;
                shifter--;
            }
            rest = rest - decision;
            }
        if (shifter % 2 == 0) {
            System.out.println(first + " Congratulations! you are a champion");
        } else {
            System.out.println(second + " Congratulations! you are a champion");
        }
    }
}
