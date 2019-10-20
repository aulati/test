package cn.aulati.test.algorithm;

import cn.aulati.test.ITest;

public class AlgorithmTest implements ITest {
    /**
     * 测试主方法
     */
    @Override
    public void runTest() {
        testFactorial1toN(50);
    }

    /**
     * output 1! to 99!
     */
    private void testFactorial1toN(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "! = ");
            String ret = Factorial.factorial100000(i);
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
    
    private void testFactorialXXX() {
        int[] a = {8, 18, 99, 1024, 9999, 99999, 999999, 999999999};
//        int[] a = {8, 99};
        for (int i : a) {
//            System.out.print(i + "! = ");
//            String ret = Factorial.factorial100000(i);
//            System.out.println(ret);
//            
            System.out.print(i + "! = ");
            String ret2 = Factorial.factorialAll(i);
            System.out.println(ret2);
            System.out.println("-------------------------------------------------------------------");
        }
    }
}
