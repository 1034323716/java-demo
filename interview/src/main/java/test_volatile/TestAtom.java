package test_volatile;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试原子性
 */
public class TestAtom {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addAge(1);
                    myData.addAtomI(1);
                }
            }, "thread-self-" + i).start();
        }

        // 为何是1不是视频中说的2，Java默认启动的线程到底有几个？
        while (Thread.activeCount() > 1) {
            Thread[] threads = new Thread[Thread.activeCount()];
            Thread.currentThread().getThreadGroup().getParent().enumerate(threads);
            System.out.println(Arrays.asList(threads));
            Thread.yield();
        }

        System.out.println(myData.age);
        System.out.println(myData.atomicI);
    }

    static class MyData {
        // 不保证原子性
        volatile int age = 0;

        public void addAge(int add) {
            // 会产生写覆盖，所以最终值不确定且不为预计的2000
            age = age + add;
        }

        // 保证原子性的方法：1、synchronized（重量级）2、AtomXXX（轻量级）
        // 为什么它就能保证原子性？cas是什么？
        AtomicInteger atomicI = new AtomicInteger();

        public void addAtomI(int add) {
            atomicI.addAndGet(add);
        }
    }
}
