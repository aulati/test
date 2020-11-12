package cn.aulati.test;

import cn.aulati.test.leetcode.LeetCodeTest;

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
        tc = new LeetCodeTest();
//        tc = new ClassInsideAnotherClassTest();
//        tc = new AlgorithmTest();
//        tc = new InnerClassTest();
//        tc = new ConcurrencyTest();

        tc.runTest();

        test();
    }

    private static void test() {
        int[][] nums = {{15, 7}, {-15, 7}, {15, -7}, {-15, -7}};

        System.out.printf("%8s %8s %8s %8s%s", "i", "j", "i/j", "i%j", System.lineSeparator());
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%8d %8d %8d %8d%s", nums[i][0], nums[i][1], nums[i][0] / nums[i][1], nums[i][0] % nums[i][1], System.lineSeparator());
        }
    }
}
