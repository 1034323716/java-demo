package queue_demo;

/**
 * @author JiYunfei
 * @date 18-8-6
 */
public interface Queue<E> {
    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e
     */
    void offer(E e);

    /**
     * 出队
     *
     * @return
     */
    E poll();

    /**
     * 队列长度
     *
     * @return
     */
    int size();
}