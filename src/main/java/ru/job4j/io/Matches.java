package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner round = new Scanner(System.in);
        int decision = 0;
        int rest = 11;
        while (rest > 0) {
            System.out.println("Сделай свой ход");
            decision = Integer.valueOf(round.nextLine());
            if (decision > 3 || decision < 1) {
                System.out.println("Ну я же сказал, что от 1 до 3х спичек. Давай снова");
                decision = 0;
            }
            rest = rest - decision;
            System.out.println("Остаток спичек: " + rest);
        }
        System.out.println("Congratulations! you are a champion");
    }
}
