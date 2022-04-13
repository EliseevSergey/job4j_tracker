package ru.job4j.lambda;

import java.util.function.Predicate;

public class PredicateCheckPositive {
    public static boolean check(int num) {
        return check(item -> item > 0, num);
    }

    public static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }
}
