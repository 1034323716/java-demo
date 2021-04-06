package jvm;

public class TestLocalVarTable {
    private void test() {
        int num;
//        System.out.println(num);
    }

    private void add() {
        int i1 = 1;
        int i2 = i1++;
        int i3 = ++i1;
    }

    private void invoke() {
        add();
    }

    private void testAdd() {
        int i = 10;
        int j = 4;
        int k = i + j;
//        System.out.println(k);
//        return k;
    }

    private void parseString() {
        byte[] bytes = {110, 105, 104, 97, 111, 13, 10};
        System.out.println(new String(bytes));
    }

    /**
     *
     * 《Practical Java》一书中把”不使用的对象应手动赋值为 null “作为一条推荐的编码规则，这并不是一个完全没有意义的操作。但是不应该对 赋 null 值有过多的依赖，主要有两点原因：
     *
     *
     *
     * 从编码的角度来讲，用恰当的变量作用域来控制变量的回收才是最优雅的解决方法。
     * 从执行角度将，使用赋值 null 的操作优化内存回收是建立在对字节码执行引擎概念模型基础上的，
     * 但是概念模型与实际执行模型可能完全不同。在使用解释器执行时，
     * 通常离概念模型还比较接近，但是一旦经过JIT 编译为本地代码才是虚拟机执行代码的主要方式，
     * 赋 null 值在JIT编译优化之后会被完全消除，这时候赋 null 值是完全没有意义的。
     * （其实，上面代码一在 JIT 编译为本地代码之后，gc() 之后内存也会被自动回收）
     *
     * @param args
     */
    public static void main(String[] args) {
        {
            byte[] bytes = new byte[1024 * 1024 * 64];//64M
        }

        // 局部变量表可以重复使用，即当上面的局部变量已经超出了使用范围了（超出作用域），下面的局部变量a就会占用bytes的slot（槽）
        // 在本方法中想对bytes的64M堆空间进行垃圾回收的办法有两个：1、bytes使用完成后值为null；2、使用a占用bytes的槽，这样64M就没有了引用的地方就可以被回收
        int a = 0;//局部变量必须显式赋值才会出现在局部变量表中，否则编译时会去掉a这个局部变量

        System.gc();
    }
}
