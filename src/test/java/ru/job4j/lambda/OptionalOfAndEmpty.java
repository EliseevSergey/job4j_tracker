package ru.job4j.lambda;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        return strings.stream().filter(item -> item.equals(value)).findFirst();
    }
}
