package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OrderConvertTest {
@Test
    public void testProcess() {
        List<Order> in = Arrays.asList(
                new Order("2", "Beer"),
                new Order("4", "Taxi"));
        HashMap<String, Order> map = OrderConvert.process(in);
        assertThat(map.get("4"), is(new Order("4", "Taxi")));
    }

    @Test
    public void whenDuplictedKeyDifValue() {
        List<Order> in = Arrays.asList(
                new Order("4", "Taxi"),
                new Order("4", "Ski")
                );
        HashMap<String, Order> map = OrderConvert.process(in);
        assertThat(map.get("4"), is(new Order("4", "Ski")));
    }

    @Test
    public void whenDuplictedKeyAndValue() {
        List<Order> in = Arrays.asList(
                new Order("4", "Taxi"),
                new Order("4", "Taxi")
        );
        HashMap<String, Order> map = OrderConvert.process(in);
        assertThat(map.get("4"), is(new Order("4", "Taxi")));
    }
}