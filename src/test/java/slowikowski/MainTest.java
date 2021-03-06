package slowikowski;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static Main main = new Main();
    private String str1;
    private String str2;

    /*
     * Tests where str2 should not be a subsequence of str1
     */

    @Nested
    class FalseStatements {
        @Test
        void str2_should_not_be_subsequence_of_str1() {
            str1 = "123456789";
            str2 = "341";
            assertFalse(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_should_not_be_subsequence_of_str1_2() {
            str1 = "";
            str2 = "341";
            assertFalse(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_not_be_subsequence_of_str1() {
            str1 = "abc";
            str2 = "abc***a";
            assertFalse(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_not_be_subsequence_of_str1_2() {
            str1 = "abcd";
            str2 = "a*dc";
            assertFalse(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_not_be_subsequence_of_str1_3() {
            str1 = "abcd";
            str2 = "a*dc*****";
            assertFalse(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_not_be_subsequence_of_str1() {
            str1 = "12345";
            str2 = "12\\*45";
            assertFalse(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_not_be_subsequence_of_str1_2() {
            str1 = "abcd";
            str2 = "a\\*";
            assertFalse(main.isSubsequence(str1, str2));
        }
    }

    /*
     * Tests where str2 should be a subsequence of str1
     */
    @Nested
    class TrueStatements {
        @Test
        void str2_should_be_subsequence_of_str1() {
            str1 = "123456789";
            str2 = "167";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_should_be_subsequence_of_str1_2() {
            str1 = "123456789";
            str2 = "";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        @DisplayName(value = "Test should pass with given empty strings")
        void str2_should_be_subsequence_of_str1_3() {
            str1 = "";
            str2 = "";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStarAtTheEnd_should_be_subsequence_of_str1() {
            str1 = "abc";
            str2 = "a*";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_be_subsequence_of_str1() {
            str1 = "acb";
            str2 = "a*c";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_be_subsequence_of_str1_2() {
            str1 = "abcd";
            str2 = "*";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_be_subsequence_of_str1_3() {
            str1 = "abcdef";
            str2 = "abcdef*";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_be_subsequence_of_str1_4() {
            str1 = "abc";
            str2 = "abc********************";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withStar_should_be_subsequence_of_str1_5() {
            str1 = "abcd";
            str2 = "a*d***";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlash_should_be_subsequence_of_str1() {
            str1 = "123\\";
            str2 = "123\\";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_be_subsequence_of_str1() {
            str1 = "a*ccd";
            str2 = "a\\*cd";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_be_subsequence_of_str1_2() {
            str1 = "*";
            str2 = "\\*";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_be_subsequence_of_str1_3() {
            str1 = "*";
            str2 = "*";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_be_subsequence_of_str1_4() {
            str1 = "1234*5678\\9#";
            str2 = "34\\*\\9#";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_be_subsequence_of_str1_5() {
            str1 = "1234567*8";
            str2 = "12*3\\*8";
            assertTrue(main.isSubsequence(str1, str2));
        }

        @Test
        void str2_withSlashAndStar_should_be_subsequence_of_str1_6() {
            str1 = "1234*5678";
            str2 = "12\\*5*8";
            assertTrue(main.isSubsequence(str1, str2));
        }
    }

    @Nested
    class ExceptionHandling {
        @Test
        void should_Throw_NullPointerException() {
            str1 = "a*ccd";
            str2 = null;
            assertThrows(NullPointerException.class, () -> main.isSubsequence(str1, str2));
        }
    }
}