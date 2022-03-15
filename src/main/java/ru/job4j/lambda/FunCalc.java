package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunCalc {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        while (start < end) {
            rsl.add(func.apply((double) start));
            start++;
        }
        return rsl;
    }
}
