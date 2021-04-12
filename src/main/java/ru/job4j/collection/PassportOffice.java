package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen in) {
        if (citizens.containsKey(in.getPassport())) {
            return false;
        } else {
            citizens.put(in.getPassport(), in);
        return true;
        }
    }

    public Citizen get(String passport) throws NoOneWasFoundException {
        if (citizens.get(passport) == null) {
            throw new NoOneWasFoundException("Nobody was found");
        }
       return citizens.get(passport);
    }
 }
