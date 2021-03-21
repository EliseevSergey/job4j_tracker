package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private String field;
    private String experince;

    public Builder() {
    }

    public Builder(String field, String experince) {
        this.field = field;
        this.experince = experince;
    }

    public Builder(String type, String level, String field, String experince) {
        this.field = field;
        this.experince = experince;
    }

    public void choiseMaterial (Task task) {
        System.out.println(this.getName() + " creates material list for " + task.getContent());
    };
}
