package ru.job4j.list;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AddElementTest {
    @Test
    public void whenFourth() {
        List<String> list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        for (String item : list) {
            System.out.println(item);
        }
        System.out.println(list.size());
        AddElement.addNewElement(list, "fourth");
        for (String item : list) {
            System.out.println(item);
        }
        System.out.println(list.size());
        boolean rsl = AddElement.addNewElement(list, "fourth");
    assertTrue(rsl);
    }

}