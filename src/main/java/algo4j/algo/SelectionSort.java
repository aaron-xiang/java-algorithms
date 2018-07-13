package algo4j.algo;

import algo4j.utils.ArrayUtil;

/**
 * Created by aaron on 7/10/18.
 */
public class SelectionSort implements Sorter {
    public void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = ArrayUtil.findMinIndex(data, i, data.length-1);
            ArrayUtil.swap(data, i, minIndex);
        }
    }
}
