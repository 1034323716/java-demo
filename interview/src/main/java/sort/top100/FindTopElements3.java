package sort.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of finding top 100 elements out of a huge int array. <br>
 * 
 * There is an array of 10000000 different int numbers. Find out its largest 100
 * elements. The implementation should be optimized for executing speed. <br>
 * 
 * Note: This is the third version of implementation, this time I make the best out
 * of the heap sort algorithm by using a minimum heap. The heap maintains the top biggest
 * numbers that guarantees the minimum number is removed every time a new number is added
 * to the heap. It saves memory usage to the limit by just using an array which size is 101
 * and a few temp elements. However, the performance is not as good as the bit map way but 
 * better than the multiple thread way. 
 * 
 * @author zhangxu04
 */
public class FindTopElements3 {

    // big array length
    private static final int ARRAY_LENGTH = 10000000;
 
    public static void main(String[] args) {
        FindTopElements3 fte = new FindTopElements3();
 
        // Get a array which is not in order and elements are not duplicate
        int[] array = getShuffledArray(ARRAY_LENGTH);
 
        // Find top 100 elements and print them by desc order in the console
        long start = System.currentTimeMillis();
        fte.findTop100(array);
        long end = System.currentTimeMillis();
        System.out.println("Costs " + (end - start) + "ms");
    }
 
    public void findTop100(int[] arr) {
        MinimumHeap heap = new MinimumHeap(100);
        for (Integer i : arr) {
            heap.add(i);
            if (heap.size() > 100) {
                heap.deleteTop();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(heap.deleteTop());
        }
    }
 
    /**
     * Get shuffled int array
     * 
     * @return array not in order and elements are not duplicate
     */
    private static int[] getShuffledArray(int len) {
        System.out
                .println("Start to generate test array... this may take several seconds.");
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
 
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
 
}