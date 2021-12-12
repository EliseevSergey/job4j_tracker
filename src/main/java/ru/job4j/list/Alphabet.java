package ru.job4j.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabet {
    public static String reformat(String input) {
        String[] lettersArray = input.split("");
        List<String> lettersList = new ArrayList<>();
        for (String letter: lettersArray) {
            lettersList.add(letter);
        }
        Collections.sort(lettersList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String letter : lettersList) {
            stringBuilder.append(letter);
        }
        String rsl = stringBuilder.toString();
        return rsl;
    }
}
