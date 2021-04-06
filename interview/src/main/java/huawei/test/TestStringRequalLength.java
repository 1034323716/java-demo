package huawei.test;

import java.util.Scanner;

public class TestStringRequalLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        String select = "";
        while (input.hasNextLine()) {
            s = input.nextLine();
            if (input.hasNextLine()) {
                select = input.nextLine();
                System.out.println(new TestStringRequalLength().equestString(s, select));
            }
        }
    }

    public int equestString(String str, String select) {
        String lowerCase = str.toLowerCase();
        String selectLower = select.toLowerCase();
        int i = 0;
        for (char c : lowerCase.toCharArray()) {
            if (c == selectLower.charAt(0)) {
                i++;
            }
        }
        return i;
    }
}
