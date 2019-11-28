package max_profit;

public class TestMaxProfit {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 67, 8, 9, 9, 2, 0};
        new TestMaxProfit().maxDiff(numbers);
    }

    /**
     * 测试用例：
     * 1、数组无序、单调递增、单调递减
     * 2、数组长度为0、1、2
     * 3、数组为null
     *
     * @param numbers
     * @return
     */
    public int maxDiff(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }
        int length = numbers.length;

        // 最大利润
        int maxDiff;
        // 最小的买入
        int min = numbers[0];
        // 最大的卖出
        int max = numbers[0];

        maxDiff = max - min;
        for (int i = 1; i < length; i++) {
            if (numbers[i - 1] < min) {
                min = numbers[i - 1];
            }
            if ((numbers[i] - min) > maxDiff) {
                max = numbers[i];
                maxDiff = max - min;
            }
        }
        System.out.println(min);
        System.out.println(max);
        System.out.println(maxDiff);
        return maxDiff;
    }
}
