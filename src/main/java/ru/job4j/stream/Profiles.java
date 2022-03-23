package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Adress> collect(List<Profile> profiles) {
        return profiles.stream().map(p -> p.getAdress())
                .collect(Collectors.toList());
    }

    public static List<Adress> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream().map(p -> p.getAdress())
                .sorted(Comparator.comparing(a -> a.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
