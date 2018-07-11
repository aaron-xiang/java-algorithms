package algo4j.algo;

import algo4j.utils.ArrayUtil;

/**
 * Created by aaron on 7/10/18.
 */
public class QuickSort implements Sorter {
    public void sort(Comparable[] data) {
        ArrayUtil.shuffle(data);
        sort(data, 0, data.length-1);
    }

    private void sort(Comparable[] data, int start, int end) {
        if (start >= end) return;
        int pivot = partition(data, start, end);
        sort(data, start, pivot-1);
        sort(data, pivot+1, end);
    }

    private int partition(Comparable[] data, int start, int end) {
        Comparable pivotKey = data[start];
        int i = start+1;
        int j = end;
        while (i <= j) {
            while(i < data.length && data[i].compareTo(pivotKey) <= 0) {
                i++;
            }
            while(data[j].compareTo(pivotKey) > 0) {
                j--;
            }
            if (i <= j) {
                ArrayUtil.swap(data, i, j);
            }
        }
        ArrayUtil.swap(data, start, j);
        return j;
    }
}
