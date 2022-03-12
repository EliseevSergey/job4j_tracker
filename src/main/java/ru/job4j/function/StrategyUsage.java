package ru.job4j.function;
import java.util.function.Predicate;

public class StrategyUsage {
    public boolean empty(String s) {
        return check(str -> str.isEmpty(), s);
    }

    public boolean startWith(String s, String pref) {
        return check(str -> str.startsWith(pref), s);
    }

    public boolean contains(String s, String key) {
        return check(str -> s.contains(key), s);
    }

    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println("Result_1 " + usage.check(str -> str.isEmpty(), ""));
        System.out.println("Result_2  "
                + usage.check(str -> str.startsWith("Fun"), "Functional in"));
        System.out.println("Result_3 " + usage.check(str -> str.contains("rn"), "Surname name"));
    }
}
