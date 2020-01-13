package singleton;

/**
 * 传统懒汉式
 * 优点：调用时才生成对象
 * 缺点：无法继承，每次都要判空
 * <p>
 * 若不使用volatile修饰，可能返回的对象不为null，却没有初始化，导致系统崩溃
 *
 * @author JiYunfei
 * @date 18-8-6
 */
public class LazySingleton {
    private static volatile LazySingleton singleton;

    private LazySingleton() {
        if (singleton != null) {
            throw new RuntimeException("this singleton");
        }
    }

    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {// 防止两个线程同时到达锁外
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}