package ru.job4j.list;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

public class AddAllElementslListTest {
@Test
public void whenTheSame() {
    List<String> left = new ArrayList<>();
    left.add("first");
    left.add("second");
    left.add("third");
    List<String> right = new ArrayList<>();
    right.add("second");
    right.add("fith");
    right.add("sixth");
    String check = "second";
    int rsl = AddAllElementslList.combiner(left, right, check);
            Assert.assertThat(rsl, is(2));
    for (String elmt : left) {
        System.out.println(elmt);
        }
    }
}