package cn.aulati.test.model;

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");
}
