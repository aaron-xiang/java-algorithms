package algo4j.ds;

/**
 * Created by aaron on 6/14/18.
 */
public class LinkedListNode<E> {
    private E value;
    private LinkedListNode<E> next;

    public LinkedListNode() {}

    public LinkedListNode(E value, LinkedListNode<E> next) {

        this.next = next;
        this.value = value;
    }

    public LinkedListNode(E value) {
        this.value = value;
    }

    public LinkedListNode<E> getNext() {

        return next;
    }

    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
