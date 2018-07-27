package algo4j.ds;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import static org.junit.Assert.*;

/**
 * Created by aaron on 7/19/18.
 */
public class BSTTest {
    private BST<Integer, Integer> bst;
    private Gson gson = new Gson();
//    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void setup() {
        bst = new BST<Integer, Integer>();
    }

    @Test
    public void testPutToTree() {
        bst.put(3, 3);
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(4, 4);
        String json = gson.toJson(bst);
        String expected = "{\"root\":{\"key\":3,\"value\":3,\"left\":{\"key\":1,\"value\":1,\"right\":{\"key\":2,\"value\":2}},\"right\":{\"key\":4,\"value\":4}}}";
//        System.out.println(json);
        assertEquals(expected, json);
    }

    @Test
    public void testGet() {
       int[] data = {3, 1, 2,4};
        for (Integer d : data) {
            bst.put(d, d);
        }
        for (Integer d: data) {
            assertEquals(d, bst.get(d));
        }
    }

    @Test
    public void testContains() {
        int[] data = {3, 1, 2,4};
        for (Integer d : data) {
            bst.put(d, d);
        }
        for (Integer d: data) {
            assertTrue(bst.contains(d));
        }
    }

    @Test
    public void testGetAllKeys() {
        int[] data = {3, 1, 2,4};
        for (Integer d : data) {
            bst.put(d, d);
        }
        Integer expectedKey = 1;
        for (Integer k : bst.keys()) {
            assertEquals(expectedKey, k);
            expectedKey += 1;
        }
    }

}