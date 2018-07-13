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
}
