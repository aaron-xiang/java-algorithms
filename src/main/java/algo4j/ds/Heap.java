package algo4j.ds;

/**
 * Created by aaron on 7/12/18.
 */
public interface Heap<T extends Comparable> {
    void add(T data);
    T remove();
}
