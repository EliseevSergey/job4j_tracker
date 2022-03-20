package ru.job4j.stream;

import net.sf.saxon.style.XSLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Profiles {
    public static List<Adress> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> p.getAdress())
                .collect(Collectors.toList());
    }

    public static List<Adress> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Adress> comparator = new Comparator<Adress>() {
            @Override
            public int compare(Adress o1, Adress o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        };
        return profiles.stream()
               .map(p -> p.getAdress())
               .sorted(comparator)
               .distinct()
               .collect(Collectors.toList());
    }
}
