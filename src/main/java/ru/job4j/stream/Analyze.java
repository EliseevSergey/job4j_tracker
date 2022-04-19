package ru.job4j.stream;

import net.sf.saxon.functions.Empty;
import ru.job4j.stream.Pupil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects()
                .stream())
                .mapToInt(item -> item.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            return new Tuple(pupil.getName(), pupil
                    .getSubjects()
                    .stream()
                    .mapToInt(Subject::getScore)
                    .average()
                    .orElse(0D));
                }
        ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap :: new,
                        Collectors.averagingDouble(
                                Subject::getScore
                        )))
                .entrySet()
                .stream()
                .map(item -> new Tuple(item.getKey(), item.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            return new Tuple(pupil.getName(), pupil
                    .getSubjects()
                .stream()
                .mapToDouble(subj -> subj.getScore())
                .sum());
        }
        ).max(Comparator.comparing())


    }
}