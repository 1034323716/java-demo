package queue_demo;

import java.util.Arrays;

/**
 * 存在并发问题
 *
 * @author JiYunfei
 * @date 18-8-6
 */
public class ArrayQueue<E> implements Queue<E> {

    Object[] queue;
    int size;

    public ArrayQueue() {
        queue = new Object[10];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void offer(E e) {
        ensureCapacity(size + 1);
        queue[size++] = e;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E data = (E) queue[0];
        System.arraycopy(queue, 1, queue, 0, size - 1);
        size--;
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity(int size) {
        if (size > queue.length) {
            int len = queue.length + 10;
            queue = Arrays.copyOf(queue, len);
        }
    }
}