package ru.job4j.stream;

import net.sf.saxon.functions.Empty;
import ru.job4j.stream.Pupil;

import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
/*        return stream.flatMap(item -> item.getSubjects()
                .stream()
                .mapToInt(sub -> sub.getScore()).average());*/
        return stream.flatMap(pupil -> )


    }
}
