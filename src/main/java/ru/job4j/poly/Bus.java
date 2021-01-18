package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport{

    @Override
    public void Go() {
    }

    @Override
    public void passagers(int passagers) {
        Scanner input = new Scanner(System.in);
        int qty = Integer.valueOf(input.nextLine());
    }

    @Override
    public int price(int fuel) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input fuel volume");
        fuel = Integer.valueOf(input.nextLine());
        System.out.println("Input price");
        int price = Integer.valueOf(input.nextLine());
        return fuel * price;
    }
}
