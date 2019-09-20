package cn.aulati.test.model;

public class Parcel8 {
    public Wrapping wrap(int x) {
        return new Wrapping(x) {
            public int value() {
                return super.value() * 10;
            }
        };
    }
}
