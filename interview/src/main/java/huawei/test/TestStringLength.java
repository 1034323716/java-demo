package huawei.test;

import java.util.Objects;
import java.util.Scanner;

public class TestStringLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s="";
        while(input.hasNextLine()){
            s=input.nextLine();
            System.out.println(new TestStringLength().lastStringLength(s));
        }
    }

    public int lastStringLength(String str) {
        int length = 0;
        if (Objects.nonNull(str) && str.length() > 0) {
            String[] s = str.split(" ");
            if (s.length > 0) {
                length = s[s.length - 1].length();
            }
        }
        return length;
    }
}
