package algo4j.utils;

/**
 * Created by aaron on 7/11/18.
 */
public class StringUtil {

    public static String reverse(String a) {
        String reversed = "";
        for (int i = a.length()-1; i >= 0; i--) {
            reversed += a.substring(i, i+1);
        }
        return reversed;
    }

    public static boolean isPalindrome(String a) {
        String letters = "";
        char[] charArray = a.toLowerCase().toCharArray();

        for (char c : charArray) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                letters += c;
            }
        }
        if (letters.equals(reverse(letters))) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isPalindromePermutation(String a) {
        int[] count = new int[26];
        char[] chars = a.toLowerCase().toCharArray();
        int oddCount = 0;

        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
            /*
                if (c >= 'A' && c <= 'Z') {
                count[c - 'Z']++;
            }

             */
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount <= 1) {
            return true;
        }
        return false;

    }
}
