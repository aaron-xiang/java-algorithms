package algo4j.ds;

import algo4j.utils.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 7/12/18.
 */
public class MaxHeapTest {
    @Test
    public void testMaxHeap() {
        Integer size = 10;
        Integer[] testData = new Integer[size];
        for (int i = 0; i < testData.length; i++) {
            testData[i] = i+1;
        }
        ArrayUtil.shuffle(testData);
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        for (int i = 0; i < testData.length; i++) {
            maxHeap.add(testData[i]);
        }
        Integer value = maxHeap.remove();
        assertEquals(size, value);
    }

}