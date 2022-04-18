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
                    .mapToInt(subject -> subject.getScore())
                    .average()
                    .orElse(0D));
                }
        ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(subject -> {
                    return subject.getName();
                }, LinkedHashMap::new,   ))
    }
}