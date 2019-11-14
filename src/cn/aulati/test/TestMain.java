package cn.aulati.test;

import cn.aulati.test.T001.ClassInsideAnotherClassTest;
import cn.aulati.test.algorithm.AlgorithmTest;
import cn.aulati.test.algorithm.Factorial;
import cn.aulati.test.concurrency.ConcurrencyTest;
import cn.aulati.test.innerclass.InnerClassTest;
import cn.aulati.test.leetcode.LeetCodeTest2;

import java.util.Scanner;

/**
 * The main class of this test project.
 *
 * @author Aulati
 */
public class TestMain {

    /**
     * booting method
     *
     * @param args application boot arguments
     */
    public static void main(String[] args) {
        // declares the variable.
        ITest tc;

//        tc = new FunctionOfFinal();
//        tc = new ExtendsAndImplements();
//        tc = new DynamicDelegateTest();
//        tc = new SortTestMain();
        tc = new LeetCodeTest2();
//        tc = new ClassInsideAnotherClassTest();
//        tc = new AlgorithmTest();
//        tc = new InnerClassTest();
//        tc = new ConcurrencyTest();

        tc.runTest();

    }
}
