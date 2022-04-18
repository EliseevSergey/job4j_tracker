package ru.job4j.stream;

import net.sf.saxon.functions.Empty;
import ru.job4j.stream.Pupil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Objects;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects()
                .stream())
                .mapToInt(item -> item.getScore())
                .average()
                .orElse(0D);
    }
}
