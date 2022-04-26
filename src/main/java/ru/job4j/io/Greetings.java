package ru.job4j.io;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello. What's your name?");
        String name = input.nextLine();
        System.out.println(name + " , nice to meet you");
    }
}
