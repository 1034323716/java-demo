package huawei.test;

import java.util.Scanner;

public class TestLuckNum {

    int ciShu = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        while (input.hasNextLine()) {
            s = input.nextLine();
            System.out.println(new TestLuckNum().isLuckNum(Integer.parseInt(s)));
        }
    }

    public boolean isLuckNum(int num) {
        return jumpLoop(num);
    }

    public boolean jumpLoop(int num) {
        ciShu ++;
        int result = 0;

        char[] chars = String.valueOf(num).toCharArray();
        for (char aChar : chars) {
            Integer integer = Integer.valueOf(aChar) - 48;
            result = result + (integer * integer);
        }

        if (result == 1) {
            return true;
        } else {
            if (ciShu > 100) {
                return false;
            } else {
                return jumpLoop(result);
            }
        }
    }
}
