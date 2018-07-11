package algo4j.algo;

import algo4j.utils.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 7/5/18.
 */
public class SortTest {
    private Sorter sorter;

    @Test
    public void testMergeSort() {
        Comparable[] data = generateTestData(201);
        assertFalse(ArrayUtil.isSorted(data));
        sorter = new MergeSort();
        sorter.sort(data);
        assertTrue(ArrayUtil.isSorted((data)));

    }

    @Test
    public void testQuickSort() {
        Comparable[] data = generateTestData(200);
        assertFalse(ArrayUtil.isSorted(data));
        sorter = new QuickSort();
        sorter.sort(data);
        assertTrue(ArrayUtil.isSorted((data)));
    }

    private Comparable[] generateTestData(int n) {
        Integer[] data = new Integer[n];
        for (int i = 1; i <= n; i++) {
            data[i-1] = i;
        }
        ArrayUtil.shuffle(data);
        return data;
    }

}