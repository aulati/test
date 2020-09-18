package cn.aulati.test.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationIteratorTest {
    @Test
    void test1() {
        CombinationIterator it = new CombinationIterator("abc", 2);

        assertEquals("ab", it.next());
        assertTrue(it.hasNext());
        assertEquals("ac", it.next());
        assertTrue(it.hasNext());
        assertEquals("bc", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void test2() {
        CombinationIterator it = new CombinationIterator("adf", 3);

        assertTrue(it.hasNext());
        assertEquals("adf", it.next());
        assertFalse(it.hasNext());
    }
}
