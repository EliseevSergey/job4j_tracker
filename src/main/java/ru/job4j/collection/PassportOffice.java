package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen in) {
        boolean rsl = false;
        if (!citizens.containsKey(in.getPassport())) {
            citizens.put(in.getPassport(), in);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
       return citizens.get(passport);
    }
 }
