package algo4j.ds;

import algo4j.utils.ArrayUtil;

/**
 * Created by aaron on 7/12/18.
 */
public class MaxHeap<T extends Comparable> implements Heap<T> {
    private static final int DEFAULT_SIZE = 100;
    private T[] data;
    private int lastIndex = 1;

    public MaxHeap() {
        data = (T[]) new Comparable[DEFAULT_SIZE];
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            data[i] = null;
        }
    }

    public MaxHeap(int size) {
        data = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }

    public void add(T d) {
        if (lastIndex >= data.length) {
            growDataArray();
        }
        data[lastIndex++] = d;
        swim();
    }

    private void swim() {
        int currentIndex = lastIndex - 1;
        while (currentIndex > 1) {
            int parentIndex = currentIndex / 2;
            if (data[parentIndex].compareTo(data[currentIndex]) >= 0) {
                break;
            }
            ArrayUtil.swap(data, currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    private void growDataArray() {
        T[] newData = (T[]) new Comparable[data.length*2];
        ArrayUtil.copy(data, newData, 0, data.length-1);
        data = newData;
    }

    public T remove() {
        ArrayUtil.swap(data, 1, lastIndex-1);
        T max = data[lastIndex-1];
        lastIndex--;
        sink();
        if (lastIndex <= data.length / 4) {
            shrinkDataArray();
        }
        return max;
    }

    private void shrinkDataArray() {
        T[] newData = (T[]) new Comparable[data.length/2];
        ArrayUtil.copy(data, newData, 0, lastIndex-1);
        data = newData;
    }

    private void sink() {
        int currentIndex = 1;
        while (currentIndex <= (lastIndex-1)/2) {
            // find the child index with the larger value
            int childIndex = currentIndex * 2;
            if (childIndex < lastIndex-1 && data[childIndex + 1].compareTo(data[childIndex]) > 0) {
                childIndex = childIndex + 1;
            }
            if (data[currentIndex].compareTo(data[childIndex]) > 0) {
                break;
            }
            ArrayUtil.swap(data, childIndex, currentIndex);
            currentIndex = childIndex;
        }
    }


}
