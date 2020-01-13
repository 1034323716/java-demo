package sort.maopao;

/**
 * @author JiYunfei
 * @date 18-8-8
 */
public class TestMaopao {
    public static void main(String[] args) {
        int[] arry = new int[]{-1, 99, 0, 1, 1000, 4};
        maopao(arry);
        for (int i : arry) {
            System.out.println(i);
        }
    }

    private static void maopao(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
