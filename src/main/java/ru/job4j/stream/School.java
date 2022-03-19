package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> rsl = new ArrayList<>();
        rsl = students.stream().filter(predict).collect(Collectors.toList());
        rsl.forEach(System.out::println);
        return rsl;
    }
}
