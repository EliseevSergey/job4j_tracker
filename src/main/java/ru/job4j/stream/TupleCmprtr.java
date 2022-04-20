package ru.job4j.stream;

import java.util.Comparator;

public class TupleCmprtr implements Comparator<Tuple> {
    @Override
    public int compare(Tuple left, Tuple right) {
        return Double.compare(left.getScore(), right.getScore());
    }
}
