package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEqual(String originTxt, String replicaTxt) {
        boolean rsl = true;
        String[] origin = originTxt.split(" ");
        String[] replica = replicaTxt.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String clon : replica) {
            if (!check.contains(clon)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
