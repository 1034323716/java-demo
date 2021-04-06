package jvm;

public class TestConstantPool {
    public static void main(String[] args) throws Throwable {
        int i = 0;
        while (true) {
            String.valueOf(i++).intern();
        }

    }
}
