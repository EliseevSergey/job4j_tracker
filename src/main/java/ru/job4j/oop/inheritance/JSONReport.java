package ru.job4j.oop.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
    String out = ("{" + System.lineSeparator() + "name : " + name + ","
            + System.lineSeparator() + "body : " + body + System.lineSeparator() + "}");
        return out;
    }
}

