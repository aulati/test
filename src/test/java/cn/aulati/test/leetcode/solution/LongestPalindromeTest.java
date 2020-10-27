package cn.aulati.test.leetcode.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LongestPalindromeTest {

    @ParameterizedTest(name = "testLongestPalindromeDP{index}")
    @CsvSource({
        "babad,bab",
        "a,a",
        "aabbccbbaa,aabbccbbaa",
        "bb,bb"
    })
    void testLongestPalindromeDP(String s, String exp) {
        String ret = LongestPalindrome.longestPalindromeDP(s);
        assertEquals(exp, ret);
    }
    
    @ParameterizedTest(name = "testLongestPalindromeDP{index}")
    @CsvSource({
        "babad,bab",
        "a,a",
        "aabbccbbaa,aabbccbbaa",
        "bb,bb"
    })
    void testLongestPalindrome(String s, String exp) {
        String ret = LongestPalindrome.longestPalindrome(s);
        assertEquals(exp, ret);
    }
}
