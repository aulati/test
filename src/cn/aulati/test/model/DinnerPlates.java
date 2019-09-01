package cn.aulati.test.model;

import java.util.Arrays;

public class DinnerPlates {
    /** 每个栈的容量 */
    int cap = 0;

    /** 有效栈的数量 */
    int scnt = 4;

    /** 所有的栈拼接在一起，存储在一个int数组中 */
    int[] data;

    /** 每个栈中下一个元素在data中的下标 */
    int[] indexes;

    public DinnerPlates(int capacity) {
        cap = capacity;
        data = new int[scnt * cap];
        indexes = new int[scnt];
        for (int i = 0; i < scnt; i++) {
            indexes[i] = cap * i;
        }
    }

    public void push(int val) {
        for (int i = 0; i < scnt; i++) {
            if (indexes[i] < cap * (i + 1)) {
                data[indexes[i]++] = val;
                return;
            }
        }

        // 所有的栈都满了，需要扩充栈了
        int newCnt = scnt << 1;
        data = Arrays.copyOf(data, newCnt * cap);
        indexes = Arrays.copyOf(indexes, newCnt);
        for (int i = scnt; i < newCnt; i++) {
            indexes[i] = cap * i;
        }

        data[indexes[scnt]++] = val;
        scnt = newCnt;
    }

    public int pop() {
        // 循环每一个栈，若栈顶元素下标表明该栈中有数据，则返回该数据，并把栈顶元素下标自减1
        for (int i = scnt - 1; i >= 0; i--) {
            if (indexes[i] > cap * i) {
                return data[indexes[i]--];
            }
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (index < scnt && indexes[index] > cap * index) {
            return data[indexes[index]--];
        }

        return -1;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
