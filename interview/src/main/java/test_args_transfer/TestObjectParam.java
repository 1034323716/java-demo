package test_args_transfer;

/**
 * @author JiYunFei
 */
public class TestObjectParam {
    public void test(Object object) {
        System.out.println("111");
    }

    public static void main(String[] args) {
        TestObjectParam param = new TestObjectParam();
        byte[] test = new byte[]{1, 2};
        param.test(test);
    }
}
