package ru.job4j.oop.inheritance;

public class Engineer extends Professional {
    private String type;
    private String level;

    public Engineer() {
    }

    public Engineer (String type, String level) {
        this.type = type;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public void resolveProblem() {
        System.out.println(this.getName() + "Engineer resolves problem");
    }
}
