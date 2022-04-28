package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {
    public static void ifPresent(int[] data) {
        if (OptionalIfPresent.max(data).isPresent()) {
            System.out.println("Max: " + OptionalIfPresent.max(data).get());
        }
    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> rsl = Optional.empty();
        if (data.length > 0) {
            int max = data[0];
            for (int i = 1; i <= data.length - 1; i++) {
                if (data[i] > max) {
                    max = data[i];
                }
            }
            rsl = Optional.of(max);
           }
        return rsl;
    }
}
