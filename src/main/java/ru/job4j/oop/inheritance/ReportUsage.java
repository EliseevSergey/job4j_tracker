package ru.job4j.oop.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport boroda = new JSONReport();
        String text = boroda.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}