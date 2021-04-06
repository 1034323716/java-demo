package huawei.test;

import java.util.ArrayList;


/**
 * 输入：[-1, 0, 1, 2, -1, -4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }

    /**
     * @param nums int整型一维数组
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 概数组用于去重复的三元组
        String temps = "";

        int length = nums.length;
        if (length < 3) {
            return result;
        }
        int a, b, c;
        for (int i = 0; i < length - 2; i++) {
            a = nums[i];
            for (int j = i + 1; j < length - 1; j++) {
                b = nums[j];
                for (int z = j + 1; z < length; z++) {
                    c = nums[z];
                    if ((a + b + c) == 0) {
                        // 找到三元组
                        ArrayList<Integer> oneResult = new ArrayList<Integer>();
                        oneResult.add(a);
                        oneResult.add(b);
                        oneResult.add(c);
                        oneResult.sort((o1, o2) -> {
                            if (o1 < o2) {
                                return -1;
                            } else if (o1 > o2) {
                                return 1;
                            }
                            return 0;
                        });
                        StringBuffer tempBuffer = new StringBuffer();
                        for (Integer integer : oneResult) {
                            tempBuffer.append(integer);
                        }
                        String temp = tempBuffer.toString();
                        if (!temps.contains(temp)) {
                            // 不存在重复的三元组
                            // 排序后添加到result
                            result.add(oneResult);

                            temps = temps + temp;
                        }
                        break;
                    }
                }
            }
        }

        // 倒转一下，否则通过率只有60%
        ArrayList<ArrayList<Integer>> resultReverse = new ArrayList<>();
        int size = result.size();
        if (size > 0) {
            for (int i = size - 1; i > -1; i--) {
                resultReverse.add(result.get(i));
            }
        }
        return resultReverse;
    }
}