package algo4j.ds;

/**
 * Created by aaron on 6/14/18.
 */
public class LinkedList<E> implements List<E> {
    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
    private int n;

    public void add(E item) {
        LinkedListNode<E> node = new LinkedListNode<E>(item);
        if (head == null) {
            head = node;
        }

        if (tail == null) {
            tail = node;
        } else {
            tail.getNext().setNext(node);
            tail = node;
        }
        n++;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        return getAt(i).getValue();
    }

    public int size() {
//        if (head == null) {
//            return 0;
//        }
//        int i = 0;
//        LinkedListNode<E> current = head;
//        while (current != null) {
//            current = current.getNext();
//            i++;
//        }
//        return i;
        return n;
    }

    public E remove(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LinkedListNode<E> prev, curr;
        if (i == 0) {
            curr = head;
            head = head.getNext();
            curr.setNext(null);
            n--;
            return curr.getValue();
        }

        prev = getAt(i - 1);
        curr = prev.getNext();
        prev.setNext(curr.getNext());
        curr.setNext(null);
        if (curr == tail) {
            tail = prev;
        }
        n--;
        return curr.getValue();

    }

    private LinkedListNode<E> getAt(int i) {
        LinkedListNode<E> current = head;
        if (head == null) {
            return null;
        }
        for (int c = 0; c < i; c++) {
            current = current.getNext();
        }
        return current;
    }
}
