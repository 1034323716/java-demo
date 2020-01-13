package test_volatile;

import java.util.concurrent.TimeUnit;

/**
 * 测试可见性
 */
public class TestVisibility {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.addAge(30);
                System.out.println("add end");
                System.out.println(myData.age);
            }
        }).start();

        System.out.println(myData.age);

        while (myData.age == 0) {
            // 这个线程中的执行要去掉，不然就会发现即使不加volatile也具备可见性
//            try {
//                TimeUnit.MILLISECONDS.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("main" + myData.age);
        }

        System.out.println("exit age:" +  myData.age);
    }
}

class MyData {
    volatile int age = 0;

    public void addAge(int add) {
        age = age + add;
    }
}
