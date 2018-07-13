package algo4j.utils;

import java.util.Random;

public class ArrayUtil {
    public static void shuffle(Comparable[] data) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            int index = i + random.nextInt(data.length - i);
            swap(data, i, index);
        }
    }

    public static boolean isSorted(Comparable[] data) {
        for (int i = 0; i < data.length-1; i++) {
            if (data[i].compareTo(data[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void copy(Comparable[] source, Comparable[] target, int start, int end) {
        if (start < 0 || end >= source.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = start; i <= end; i++) {
            target[i] = source[i];
        }
    }

    public static int findMinIndex(Comparable[] data, int start, int end) {
        Comparable min = data[start];
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (data[i].compareTo(min) < 0) {
                min = data[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
