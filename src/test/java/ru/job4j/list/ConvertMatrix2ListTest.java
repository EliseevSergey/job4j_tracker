package ru.job4j.list;

import java.util.List;
import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void testToList() {
      ConvertMatrix2List list = new ConvertMatrix2List();
      int[][] matrix = {
              {1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}
      };

      List<Integer> result = list.toList(matrix);
      List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
      assertThat(expected, is(result));
    }
}