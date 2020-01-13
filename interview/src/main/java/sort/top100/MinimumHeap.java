package sort.top100;

class MinimumHeap {
 
    int[] items;
    int size;
 
    public MinimumHeap(int size) {
        items = new int[size + 1];
        size = 0;
    }
 
    void shiftUp(int index) {
        int intent = items[index];
        while (index > 0) {
            int pindex = (index - 1) / 2;
            int parent = items[pindex];
            if (intent < parent) {
                items[index] = parent;
                index = pindex;
            } else {
                break;
            }
        }
        items[index] = intent;
    }
 
    void shiftDown(int index) {
        int intent = items[index];
        int leftIndex = 2 * index + 1;
        while (leftIndex < size) {
            int minChild = items[leftIndex];
            int minIndex = leftIndex;
 
            int rightIndex = leftIndex + 1;
            if (rightIndex < size) {
                int rightChild = items[rightIndex];
                if (rightChild < minChild) {
                    minChild = rightChild;
                    minIndex = rightIndex;
                }
            }
 
            if (minChild < intent) {
                items[index] = minChild;
                index = minIndex;
                leftIndex = index * 2 + 1;
            } else {
                break;
            }
        }
        items[index] = intent;
    }
 
    public void add(int item) {
        items[size++] = item;
        shiftUp(size - 1);
    }
 
    public int deleteTop() {
        if (size < 1) {
            return 0;
        }
        int maxItem = items[0];
        int lastItem = items[size - 1];
        size--;
        if (size < 1) {
            return lastItem;
        }
        items[0] = lastItem;
        shiftDown(0);
        return maxItem;
    }
 
    public boolean isEmpty() {
        return size < 1;
    }
 
    public int size() {
        return size;
    }
 
    /**
     * MinimumHeap main test
     * @param args
     */
    public static void main(String[] args) {
        MinimumHeap heap = new MinimumHeap(7);
        heap.add(2);
        heap.add(3);
        heap.add(5);
        heap.add(1);
        heap.add(4);
        heap.add(7);
        heap.add(6);
 
        heap.deleteTop();
        heap.deleteTop();
 
        while (!heap.isEmpty()) {
            System.out.println(heap.deleteTop());
        }
    }
 
}