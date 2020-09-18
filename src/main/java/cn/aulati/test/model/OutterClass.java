package cn.aulati.test.model;

public class OutterClass {
    private int x = 1;

    public void setX(int i) {
        x = i;
    }
    
    public void f() {
        System.out.println("OutterClass.f(), x = " + x);
    }
    
    public class InnerClass {
        public OutterClass outer() {
            return OutterClass.this;
        }
    }
    
    public InnerClass inner() {
        return new InnerClass();
    }
}
