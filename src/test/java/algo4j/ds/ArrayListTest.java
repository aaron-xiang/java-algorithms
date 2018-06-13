package algo4j.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.portable.IndirectionException;

import static org.junit.Assert.*;

/**
 * Created by aaron on 6/12/18.
 */
public class ArrayListTest {
    private List<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayList<Integer>();
    }
    @Test
    public void testAddItem() throws Exception {
//        List<Integer> list = new ArrayList<Integer>();
        assertEquals(0, list.size());
        Integer item = 1;
        list.add(item);
        assertEquals(1, list.size());
        assertEquals(item, list.get(0));
    }

    @Test
    public void testAddItemGrowth() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        assertEquals(20, list.size());
    }

    @Test
    public void testRemoveItem() {
        Integer item = 1;
        list.add(item);
        assertEquals(item, list.remove(0));
    }

    @Test
    public void testRemoveToResize() {
        for (int i = 0; i < 200; i++) {
            list.add(i);
        }
        assertEquals(200, list.size());
        for (int i = 199; i >= 20; i--) {
            list.remove(i);
        }
        assertEquals(20, list.size());
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