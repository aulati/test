package cn.aulati.test.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountBinarySubstringsTest {
    @ParameterizedTest(name = "testCountBinarySubstrings{index}")
    @CsvSource({
        "00110011,6",
        "10101,4",
        "1,0",
        "01,1",
        "10,1",
        "0011,2"
    })
    void testCountBinarySubstrings(String s, int exp) {
        int ret = CountBinarySubstrings.getInstance().countBinarySubstrings(s);
        assertEquals(exp, ret);
    }
}
