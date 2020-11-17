package cn.aulati.test.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterviewTest {
    @Test
    void testSolve1() {
        String s = "1+2";
        int ret = Interview.solve(s);
        assertEquals(3, ret);
    }

    @Test
    void testSolve2() {
        String s = "1+2-5";
        int ret = Interview.solve(s);
        assertEquals(-2, ret);
    }

    @Test
    void testSolve3() {
        String s = "1+2-(5+2)+4";
        int ret = Interview.solve(s);
        assertEquals(0, ret);
    }

    @Test
    void testSolve4() {
        String s = "1+(2-5)+(2+4)";
        int ret = Interview.solve(s);
        assertEquals(4, ret);
    }
}
