package CF.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws Exception {
        IA ia = (IA) createObject(IA.class.getName()+"$getName=Abc");
        System.out.println(ia.getName());
        ia = (IA) createObject(IA.class.getName()+"$getName=Bcd");
        System.out.println(ia.getName());

    }

    public static Object createObject(String str) throws Exception {
        //解析
        int $Index = str.indexOf("$");
        int equalIndex = str.indexOf("=");
        String className = str.substring(0, $Index);
        String methodName = str.substring($Index + 1, equalIndex);
        String returnV = str.substring(equalIndex + 1, str.length());

        // 代理
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals(methodName)) {
                    return returnV;
                }
                return "";
            }
        };
        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName(className)}, invocationHandler);

        return proxyInstance;
    }
}
