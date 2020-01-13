package queue_demo;

/**
 * @author JiYunfei
 * @date 18-8-6
 */
public class LinkedQueue<E> implements Queue<E> {

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void offer(E e) {
        Node<E> node = new Node<E>(e);
        if (isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public int size() {
        Node<E> temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

}