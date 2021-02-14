package ru.job4j.tracker;

public class ValidateInput extends Consoleinput {
    @Override
    public int askInt (String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please input number , not text");
            }
        } while (invalid);
        return value;
    }
}
