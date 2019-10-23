package cn.aulati.test.innerclass;

public class DotThis {
    private int id;

    public DotThis(int ident) {
        this.id = ident;
    }
    
    public void f() {
        System.out.println(this);
    }
    
    @Override
    public String toString() {
        return "DotThis " + id;
    }

    public Inner inner() {
        return new Inner();
    }

    /**
     * Inner class inside DotThis
     */
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

//    public static void main(String[] args) {
//        DotThis dt = new DotThis(1);
//        DotThis.Inner dti = dt.inner();
//        dti.outer().f();
//
//        DotThis dt2 = new DotThis(2);
//        DotThis.Inner dti2 = dt2.inner();
//        dti2.outer().f();
//    }
}
