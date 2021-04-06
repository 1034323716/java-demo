public class TestIntEqual {
    public static void main(String[] args) {
        int a = 2000;
        Integer b = 2000;
        System.out.println(a == b);

        Integer c = 100;
        Integer d = Integer.valueOf(100);
        Integer e = new Integer(100);
        System.out.println(c == d);
        System.out.println(d == e);
    }
}
