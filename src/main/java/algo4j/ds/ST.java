package algo4j.ds;

/**
 * Created by aaron on 7/19/18.
 */
public interface ST<K extends Comparable, V> {
    void put(K key, V value);
    V get(K key);
    void delete(K key);
    boolean contains(K key);
    int size();
    Iterable<K> keys();

}
