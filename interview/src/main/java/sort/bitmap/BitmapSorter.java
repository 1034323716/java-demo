package sort.bitmap;

public class BitmapSorter {
    public static void main(String[] args) {
        int[] arr = {1, 7, -3, 0, 0, 6, 6, 9, -11};
        bitmapSort(arr);
        for (int i : arr) {
            System.out.print(i + " , ");
        }
    }

    /**
     * 使用位图法进行排序
     *
     * @param arr
     */
    public static void bitmapSort(int[] arr) {
// 找出数组中最值
        int max = arr[0];
        int min = max;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
// 得到位图数组
        int[] newArr = new int[max - min + 1];
        for (int i : arr) {
            int index = i - min;
            newArr[index]++;
        }
// 重整arr中的元素
        int index = 0;
        for (int i = 0; i < newArr.length; i++) {
            while (newArr[i] > 0) {
                arr[index] = i + min;
                index++;
                newArr[i]--;
            }
        }
    }
}