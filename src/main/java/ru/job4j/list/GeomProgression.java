package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> prg = new ArrayList<>();
        int rsl = 0;
        for (int i = 1; i <= count; i++) {
            int item = (int) (first * Math.pow(denominator, (i - 1)));
            System.out.println(item);
            prg.add(item);
            rsl = rsl + prg.get(i - 1);
        }
       return rsl;
    }
}
