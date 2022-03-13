package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 2", 120),
                new Attachment("image 3", 23),
        };
        for (Attachment attachment : atts) {
            System.out.println("Before " + attachment);

        }
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);

        Comparator<Attachment> cmp =
                (left, right) -> Integer.compare(left.getSize(), right.getSize());
        Arrays.sort(atts, cmp);
        for (Attachment attachment : atts) {
            System.out.println("After " + attachment);

        }
    }
}
