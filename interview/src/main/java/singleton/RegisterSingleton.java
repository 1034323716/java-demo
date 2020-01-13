package singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登记式单例实际上维护的是一组单例类的实例，将这些实例存储到一个Map(登记簿)
 * 中，对于已经登记过的单例，则从工厂直接返回，对于没有登记的，则先登记，而后
 * 返回
 *
 * 只能从这里拿，拿到的才是单例的，从其他地方获取就不是单例了
 *
 * IOC容器的思想
 *
 * @author JiYunfei
 * @date 18-8-7
 */
public class RegisterSingleton {

    private static Map<String, Object> registry = new ConcurrentHashMap<>();

    public static Object getSingleton(String className) throws Exception {
        if (className == null || "".equals(className)) {
            throw new RuntimeException("ClassName Empty");
        }
        if (registry.get(className) == null) {
            registry.put(className, Class.forName(className).newInstance());
        }
        return registry.get(className);

    }

}
