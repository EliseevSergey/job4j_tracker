package ru.job4j.stream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.List;

public class AnalyzeTest {
    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                ).stream()
        );
        assertThat(average, is(100D));
    }
}
