package cn.aulati.test.concurrency;

import cn.aulati.test.util.CountingIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListComparison {
    public static void test(int reps, int cycles, int size) {
        Tester.initMain(reps, cycles, size);
        new SynchronizedArrayListTest(10, 0);
        new SynchronizedArrayListTest(9, 1);
        new SynchronizedArrayListTest(5, 5);
        new CopyOnWriteArrayListTest(10, 0);
        new CopyOnWriteArrayListTest(9, 1);
        new CopyOnWriteArrayListTest(5, 5);
        Tester.exec.shutdown();
    }
}

class SynchronizedArrayListTest extends ListTest {
    List<Integer> containerInitializer() {
        return Collections.synchronizedList(new ArrayList<Integer>(new CountingIntegerList(containerSize)));
    }

    SynchronizedArrayListTest(int nReaders, int nWriters) {
        super("Synchronized ArrayList", nReaders, nWriters);
    }
}

class CopyOnWriteArrayListTest extends ListTest {
    List<Integer> containerInitializer() {
        return new CopyOnWriteArrayList<>(new CountingIntegerList(containerSize));
    }

    CopyOnWriteArrayListTest(int nReaders, int nWriters) {
        super("CopyOnWriteArrayList", nReaders, nWriters);
    }
}

abstract class ListTest extends Tester<List<Integer>> {
    ListTest(String id, int nReaders, int nWriters) {
        super(id, nReaders, nWriters);
    }
    
    class Reader extends TestTask {
        long result = 0;
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    result += testContainer.get(index);
                }
            }
        }

        @Override
        void putResult() {
            readResult += result;
            readTime += duration;
        }
    }
    
    class Writer extends TestTask {
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    testContainer.set(index, writeData[index]);
                }
            }
        }
        void putResult() {
            writeTime += duration;
        }
    }
    
    void startReaderAndWriters() {
        for (int i = 0; i < nReaders; i++) {
            exec.execute(new Reader());
        }
        for (int i = 0; i < nWriters; i++) {
            exec.execute(new Writer());
        }
    }
}
