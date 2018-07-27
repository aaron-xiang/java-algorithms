package algo4j.utils;

import java.util.ArrayList;
import java.util.List;
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

    public static int findMaxIndex(Comparable[] data, int start, int end) {
        Comparable max = data[start];
        int maxIndex = start;
        for (int i = start; i <=  end; i++) {
            if (data[i].compareTo(max) > 0) {
                max = data[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[][] clear(int[][] grid) {
        List<Integer> row = new ArrayList<Integer>();
        List<Integer> col = new ArrayList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (Integer i : row) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = 0;
            }
        }
        for (Integer i : col) {
            for (int j = 0; j < grid.length; j++) {
                grid[j][i] = 0;
            }
        }

        return grid;
    }

    public static int[][] rotate(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];
        List<Integer> newOrder = new ArrayList<Integer>();
        int index = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length-1; j >= 0; j--) {
                newOrder.add(grid[j][i]);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                newGrid[i][j] = newOrder.get(index);
                index++;
            }
        }

        return newGrid;
    }

}
