package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student("Surname1", 10),
                new Student("Surname2", 20),
                new Student("Surname5", 50),
                new Student("Surname7", 70),
                new Student("Surname9", 90));
        List<Student> expected = List.of(
                new Student("Surname7", 70),
                new Student("Surname9", 90));
        List<Student> rsl = School.collect(students, p -> p.getScore() >= 70);
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student("Surname1", 10),
                new Student("Surname2", 20),
                new Student("Surname5", 50),
                new Student("Surname6", 60),
                new Student("Surname7", 70),
                new Student("Surname9", 90));
        List<Student> expected = List.of(
                new Student("Surname5", 50),
                new Student("Surname6", 60));
        List<Student> rsl = School.collect(students,
                p -> (p.getScore() >= 50) && (p.getScore() < 70));
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenCollectClassC() {
        School school = new School();
        List<Student> students = List.of(
                new Student("Surname1", 10),
                new Student("Surname2", 20),
                new Student("Surname5", 50),
                new Student("Surname7", 70),
                new Student("Surname9", 90));
        List<Student> expected = List.of(
                new Student("Surname1", 10),
                new Student("Surname2", 20));
        List<Student> rsl = School.collect(students, p -> p.getScore() < 50);
        assertThat(expected, is(rsl));
    }
}