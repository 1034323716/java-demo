package singleton;

/**
 * 升级版懒汉式
 * 静态内部类在被调用时才初始化
 *
 * @author JiYunfei
 * @date 18-8-7
 */
public class UpgradeLazySingleton {

    public static UpgradeLazySingleton getSingleton() {
        return SingletonContainer.singleton;
    }

    private UpgradeLazySingleton() {
        if (SingletonContainer.singleton != null) {
            throw new RuntimeException("this singleton");
        }
    }

    private static class SingletonContainer {
        private static final UpgradeLazySingleton singleton = new UpgradeLazySingleton();
    }
}
