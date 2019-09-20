package cn.aulati.test.T001;

import cn.aulati.test.ITest;
import cn.aulati.test.model.OutterClass;
import cn.aulati.test.model.Parcel8;
import cn.aulati.test.model.Wrapping;

public class ClassInsideAnotherClassTest implements ITest {

    /**
     * start method of this test class.
     *
     * @see cn.aulati.test.ITest#runTest()
     */
    @Override
    public void runTest() {
        test01();
        test02();
        test03();
    }

    private void test01() {
        OutterClass oc = new OutterClass();
        oc.setX(5);
        
        OutterClass.InnerClass ocic = oc.inner();
        ocic.outer().f();
        System.out.println("------------------------------------------");
    }
    
    private void test02() {
        OutterClass oc = new OutterClass();
        oc.setX(9);

        OutterClass.InnerClass ocic = oc.new InnerClass();
        ocic.outer().f();
        System.out.println("------------------------------------------");
    }
    
    private void test03() {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrap(7);
        System.out.println(w.value()); // 70
        System.out.println("------------------------------------------");
    }
}
