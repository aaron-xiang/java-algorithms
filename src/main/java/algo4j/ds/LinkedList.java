package algo4j.ds;

import java.util.*;
import java.util.ArrayList;

/**
 * Created by aaron on 6/14/18.
 */
public class LinkedList<E> implements List<E> {
    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
    private int n;

    public void prepend(E item) {

    }
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


    public LinkedList<E> reverse() {
        java.util.List<E> items = new ArrayList<E>();
        LinkedList<E> reversed = new LinkedList<E>();

        while(head.getNext() != null) {
            items.add(head.getValue());
            head=head.getNext();
        }
        for (int i = items.size() - 1; i >= 0; i--) {
            reversed.add(items.get(i));
        }
        return reversed;
    }


}
