package algo4j.ds;

/**
 * Created by aaron on 6/12/18.
 */
public interface List<E> {
    void add(E item);
    E get(int i);
    int size();
    E remove(int i);
}
