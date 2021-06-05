package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        switch (Integer.compare(o1.length(), o2.length())) {
            case (1):
                for (int index = 0; index < o2.length(); index++) {
                    int decision = Character.compare(o1.charAt(index), o2.charAt(index));
                    if (decision != 0) {
                        rsl = decision;
                        break;
                    }
                    if (index == o2.length() - 1 && decision == 0) {
                        rsl = 1;
                    }
                }
                break;
            case (-1):
                for (int index = 0; index < o1.length(); index++) {
                    int decision = Character.compare(o1.charAt(index), o2.charAt(index));
                    if (decision != 0) {
                        rsl = decision;
                        break;
                    }
                    if (index == o1.length() - 1 && decision == 0) {
                        rsl = -1;
                    }
                }
                break;
            case (0):
                for (int index = 0; index < o1.length(); index++) {
                    int decision = Character.compare(o1.charAt(index), o2.charAt(index));
                    if (decision != 0) {
                        rsl = decision;
                        break;
                    }
                }
                break;
            }
    return rsl;
    }
}
