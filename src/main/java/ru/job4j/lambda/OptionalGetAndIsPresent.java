package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {
    public static int get(int[] data, int el) {
        if (OptionalGetAndIsPresent.indexOf(data, el).isPresent()) {
            return OptionalGetAndIsPresent.indexOf(data, el).get();
        } else {
            return -1;
            }
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> rsl = Optional.empty();
        for (int i = 0; i <= data.length - 1; i++) {
            if (data[i] == el) {
                rsl = Optional.of(i);
                break;
            }
        }
        return rsl;
    }
}
