package ru.job4j.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> multiplication = list.stream().reduce((a, b) -> a * b);
        System.out.println(multiplication.get());

        Stream parallelStream = list.parallelStream();
        System.out.println(parallelStream.isParallel());
        Optional<Integer> multiplicationParallel = list.stream().reduce((a, b) -> a * b);
        System.out.println(multiplicationParallel.get());
    }
}
