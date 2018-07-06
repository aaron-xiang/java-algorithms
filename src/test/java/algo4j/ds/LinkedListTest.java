package algo4j.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 6/14/18.
 */
public class LinkedListTest {
    private List<Integer> list;

    @Before
    public void beforeTest() {
        list = new LinkedList<Integer>();
    }
    @Test
    public void testAddItem() throws Exception {
        assertEquals(0, list.size());
        Integer item = 2;
        list.add(item);
        assertEquals(1, list.size());
        assertEquals(item, list.get(0));
    }


    @Test
    public void testRemoveItem() {
        Integer item = 1;
        list.add(item);
        assertEquals(item, list.remove(0));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveItemWithException() {
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveItemWithException2() {
        list.get(100);
    }
}