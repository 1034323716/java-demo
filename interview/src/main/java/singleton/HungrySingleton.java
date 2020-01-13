package singleton;

/**
 * 饿汉式
 * 优点：简单方便，不用考虑多线程问题
 * 缺点：无法继承
 *
 * @author JiYunfei
 * @date 18-8-6
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
        if (singleton != null) {
            throw new RuntimeException("this singleton");
        }
    }

    public static HungrySingleton getSingleton() {
        return singleton;
    }
}