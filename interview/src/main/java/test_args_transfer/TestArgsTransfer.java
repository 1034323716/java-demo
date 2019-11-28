package test_args_transfer;

public class TestArgsTransfer {
    public static void main(String[] args) {
        TestArgsTransfer testArgsTransfer = new TestArgsTransfer();
        Integer a = 100000000;
        Integer b = Integer.valueOf(5);
        testArgsTransfer.transferInteger(a);
        testArgsTransfer.transferInteger(b);

        String s = "jiyunfei";
        testArgsTransfer.transferString(s);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(s.hashCode());
    }
    private void transferInteger(Integer a) {
        System.out.println("transferInteger0:"+a.hashCode());
        a = a + 1;
        System.out.println("transferInteger1:"+a.hashCode());
    }

    private void transferString(String string) {
        System.out.println("transferString0:"+string.hashCode());
        string = "hello";
        System.out.println("transferString1:"+string.hashCode());
    }
}
