package jvm.dynamic_link;

public class System2 {
    public final System2 out = new System2();

    public final void test() {

    }

    private final void test2() {
        this.test();
    }

    public static void main(String[] args) {
        new System2().out.test();
    }
}

class System3 extends System2 {

}
