package cn.aulati.test.model;

public class Parcel8 {
    public Wrapping wrap(int x) {
        return new Wrapping(x) {
            public int value() {
//                int j = i * 10;
                return super.value() * 10;
            }
        };
    }
}
