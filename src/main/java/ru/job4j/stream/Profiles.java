package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Profiles {
    public static Stream<Adress> adressPool(List<Profile> profiles) {
        return profiles.stream().map(p -> p.getAdress());
    }

    public static List<Adress> collect(List<Profile> profiles) {
        return Profiles.adressPool(profiles)
                .collect(Collectors.toList());
    }

    public static List<Adress> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Adress> comparator = Comparator.comparing(a -> a.getCity());
        return Profiles.adressPool(profiles).sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
    }
}
