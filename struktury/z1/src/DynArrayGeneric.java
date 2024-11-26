import java.util.Arrays;

public class DynArrayGeneric<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private Object[] tab;
    private int currSize;

    public DynArrayGeneric(int initialCapacity) {
        this.tab = new Object[initialCapacity];
        this.currSize = 0;
    }

    public DynArrayGeneric() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    private void increaseCapacityIfNeeded() {
        if (this.tab.length == this.currSize) {
            Object[] newTab = new Object[this.tab.length * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
    }

    public int size() {
        return this.currSize;
    }

    public void add(T value) {
        this.increaseCapacityIfNeeded();
        this.tab[this.currSize] = value;
        this.currSize++;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.currSize)
            throw new IndexOutOfBoundsException();

        System.arraycopy(this.tab, index + 1, this.tab, index, this.currSize - index - 1);
        this.currSize--;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= this.currSize)
            throw new IndexOutOfBoundsException();

        return (T) this.tab[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.tab, this.currSize));
    }
}
