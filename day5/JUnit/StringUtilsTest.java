

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtils {

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(reverse(cleaned));
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

public class StringUtilsTest {
    
    private StringUtils stringUtils;

    @BeforeEach
    public void setup() {
        stringUtils = new StringUtils();
    }

    @Test
    public void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"), "Reverse of 'abc' should be 'cba'");
        assertEquals("4321", stringUtils.reverse("1234"), "Reverse of '1234' should be '4321'");
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"), "'madam' is a palindrome");
        assertTrue(stringUtils.isPalindrome("RaceCar"), "'RaceCar' is a palindrome (case-insensitive)");
        assertFalse(stringUtils.isPalindrome("hello"), "'hello' is not a palindrome");
        assertTrue(stringUtils.isPalindrome("A man a plan a canal Panama"), "Phrase is a palindrome ignoring spaces and case");
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"), "Should convert to uppercase");
        assertEquals("WORLD", stringUtils.toUpperCase("World"), "Should convert to uppercase");
    }
}

