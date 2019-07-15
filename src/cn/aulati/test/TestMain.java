package cn.aulati.test;

import cn.aulati.test.leetcode.LeetCodeTest;

/**
 * The start class of this test project.
 * @author Aulati
 *
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // declares the variable.
        ITest tc;

//        tc = new FunctionOfFinal();
//        tc = new ExtendsAndImplements();
//        tc = new DynamicDelegateTest();
//        tc = new SortTestMain();
        tc = new LeetCodeTest();

        tc.runTest();
    }
}
