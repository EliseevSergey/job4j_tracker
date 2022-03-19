package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Adress> collect(List<Profile> profiles) {
        List<Adress> rsl = new ArrayList<>();
        rsl = profiles.stream().map(p -> p.getAdress()).collect(Collectors.toList());
        return rsl;
    }
}
