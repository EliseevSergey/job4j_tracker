package ru.job4j.lambda;

import ru.job4j.tracker.StubOutput;

import java.util.Arrays;
import java.util.Comparator;

public class StringLength {
    public static void main(String[] args) {
        String[] book = {"big", "bigger", "biggest"};
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(book, cmpText);
        for (String strg : book) {
            System.out.println("After cmpText: " + strg);
        }
        Comparator<String> cmpDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());
        Arrays.sort(book, cmpDescSize);
            for (String strg : book) {
            System.out.println("After cmpDescSize: " + strg);
        }
    }
}