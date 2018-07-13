package algo4j.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 7/12/18.
 */
public class StringUtilTest {
    @Test
    public void testIsPalindrome() {
        String testString = "A lad named E. Mandala";
        assertTrue(StringUtil.isPalindrome(testString));
    }

    @Test
    public void testNotPalindrome() {
        String testString = "not a palindrome";
        assertFalse(StringUtil.isPalindrome(testString));
    }

    @Test
    public void testReverseString() {
        String testString = "yes";
        String expected = "sey";
        assertEquals(expected, StringUtil.reverse(testString));
    }
}
