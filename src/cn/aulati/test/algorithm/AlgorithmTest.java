package cn.aulati.test.algorithm;

import cn.aulati.test.ITest;

public class AlgorithmTest implements ITest {
    /**
     * 测试主方法
     */
    @Override
    public void runTest() {
        testFactorial1000();
    }

    /**
     * output 1! to 99!
     */
    private void testFactorial1to100() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "! = ");
            String ret = Factorial.factorial(i);
            System.out.println(ret);
            System.out.println("-------------------------------------------------------------------");
        }
    }

    /**
     * print 1000! to console.
     */
    private void testFactorial1000() {
        System.out.print("1000! = ");
        String ret = Factorial.factorial(1000);
        System.out.println(ret);
        System.out.println("-------------------------------------------------------------------");
    }
}
