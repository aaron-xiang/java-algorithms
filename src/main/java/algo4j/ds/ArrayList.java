package algo4j.ds;


/**
 * Created by aaron on 6/12/18.
 */
public class ArrayList<E> implements List<E> {
    private E[] data;
    private int currentIndex = 0;

    public ArrayList() {
        this.data = (E[]) new Object[10];
    }

    public ArrayList(int initialSize) {
        this.data = (E[]) new Object[initialSize];
    }

    public void add(E item) {
        data[currentIndex++] = item;
        checkSpace();
    }

    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= currentIndex)
            throw new IndexOutOfBoundsException();
        return data[i];
    }

    public int size() {
        return currentIndex;
    }

    public E remove(int i) {
        E removed = data[i];
        for (int j = i; j < currentIndex - 1; j++) {
            data[j] = data[j + 1];
        }
        data[currentIndex - 1] = null;
        currentIndex--;
        checkSpace();
        return removed;
    }

    private void checkSpace() {
        if (currentIndex >= data.length) {
            E[] newData = (E[]) new Object[data.length * 2];
            copyArray(data, newData);
            data = newData;
        } else if (currentIndex <= data.length/4 && data.length > 10) {
            E[] newData = (E[]) new Object[data.length / 2];
            copyArray(data, newData);
            data = newData;
        }
    }

    private void copyArray(E[] src, E[] dst) {
        for (int i = 0; i < currentIndex; i++) {
            dst[i] = src[i];
        }
    }
}
