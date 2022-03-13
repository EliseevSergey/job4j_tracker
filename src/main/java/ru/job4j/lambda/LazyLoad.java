package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLoad {
    public static void main(String[] args) {
        String[] names = {"Ivan", "Kolyan"};
        Comparator<String> lenght = (left, right) -> {
            System.out.println("cmp is working");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lenght);
    }
}

