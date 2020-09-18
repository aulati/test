package cn.aulati.test.innerclass;

import cn.aulati.test.ITest;

public class InnerClassTest implements ITest {
    /**
     * Test
     */
    @Override
    public void runTest() {
        DotThis dt = new DotThis(1);
        DotThis.Inner dti = dt.inner();
        dti.outer().f();

        DotThis dt2 = new DotThis(2);
        DotThis.Inner dti2 = dt2.inner();
        dti2.outer().f();
    }
}
