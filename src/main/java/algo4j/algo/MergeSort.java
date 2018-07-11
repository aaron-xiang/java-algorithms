package algo4j.algo;

import algo4j.utils.ArrayUtil;

/**
 * Created by aaron on 7/5/18.
 */
public class MergeSort implements Sorter {
    private Comparable[] temp;

    public void sort(Comparable[] data) {
        temp = new Comparable[data.length];
        ArrayUtil.copy(data, temp, 0, data.length-1);
        sort(data, 0, data.length-1);
    }

    private void sort(Comparable[] data, int start, int end) {
        if (start >= end) return;
        int mid = (start + end)/2;
        sort(data, start, mid);
        sort(data, mid + 1, end);
        merge(data, start, mid, end);
    }

    private void merge(Comparable[] data, int start, int mid, int end) {
        for (int k = start; k <= end; k++) {
            temp[k] = data[k];
        }
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid || j <= end) {
            if (i > mid) {
                data[k++] = temp[j++];
            }
            else if (j > end) {
                data[k++] = temp[i++];
            }
            else if (temp[j].compareTo(temp[i]) <= 0) {
                data[k++] = temp[j++];
            }
            else {
                data[k++] = temp[i++];
            }
        }
//        for (int k = start; k <= end ; k++) {
//            if (i > mid) {
//                data[k] = temp[j++];
//            }
//            else if (j > end) {
//                data[k] = temp[i++];
//            }
//            else if (temp[j].compareTo(temp[i]) <= 0) {
//                data[k] = temp[j++];
//            }
//            else {
//                data[k] = temp[i++];
//            }
//        }
    }
}
