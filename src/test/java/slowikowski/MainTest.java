package slowikowski;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static Main main = new Main();

    @Test
    void str2_should_be_subsequence_of_str1() {
        String str1 = "123456789";
        String str2 = "167";
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    void str2_should_be_subsequence_of_str1_2() {
        String str1 = "123456789";
        String str2 = "";
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    void str2_should_be_subsequence_of_str1_3() {
        String str1 = "";
        String str2 = "";
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    @DisplayName(value = "Test should pass with given empty strings")
    void str2_should_be_subsequence_of_str1_4() {
        String str1 = "";
        String str2 = "";
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    void str2_withSlash_should_be_subsequence_of_str1() {
        String str1 = "123\\";
        String str2 = "123\\";
        System.out.println(str2.length());
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    void str2_should_not_be_subsequence_of_str1() {
        String str1 = "123456789";
        String str2 = "341";
        assertFalse(main.isSubsequence(str1, str2));
    }

    @Test
    void str2_withStar_should_be_subsequence_of_str1() {
        String str1 = "abc";
        String str2 = "a*c";
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    void str2_withSlashAndStar_should_be_subsequence_of_str1() {
        String str1 = "a*ccd";
        String str2 = "a\\*cc";
        assertTrue(main.isSubsequence(str1, str2));
    }

    @Test
    void should_Throw_NullPointerException() {
        String str1 = "a*ccd";
        String str2 = null;
        assertThrows(NullPointerException.class, () -> main.isSubsequence(str1, str2));
    }

    @Test
    void str2_withSlashAndStar_should_be_subsequence_of_str1_2() {
        String str1 = "*";
        String str2 = "\\*";
        assertTrue(main.isSubsequence(str1, str2));
    }


}