package algo4j.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 7/18/18.
 */
public class ArrayUtilTest {

    @Test
    public void testClear() {
        int[][] testArray = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertEquals(expected, ArrayUtil.clear(testArray));
    }

    @Test
    public void testRotate() {
        int[][] testArray = new int[][]{
                {3, 2, 1},
                {3, 2, 1},
                {3, 2, 1}
        };
        int[][] expected = new int[][]{
                {3, 3, 3},
                {2, 2, 2},
                {1, 1, 1}

        };
        assertEquals(expected, ArrayUtil.rotate(testArray));
    }
}