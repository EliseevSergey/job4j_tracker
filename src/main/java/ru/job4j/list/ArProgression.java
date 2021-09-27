package ru.job4j.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int rsl = data.get(data.size() - 1) + data.get(data.size() - 2);
        for (int i = 0; i < data.size() - 2; i++) {
            if ((data.get(i) + data.get(i + 2)) / 2 == data.get(i + 1)) {
                rsl = data.get(i) + rsl;
            } else {
                rsl = 0;
                return rsl;

            }
        }
        return rsl;
    }
}
