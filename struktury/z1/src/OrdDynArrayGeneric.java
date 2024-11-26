public class OrdDynArrayGeneric<T extends Comparable<T>> {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private Object[] tab;
    private int currSize;

    public OrdDynArrayGeneric(int initialCapacity) {
        this.tab = new Object[initialCapacity];
        this.currSize = 0;
    }

    public OrdDynArrayGeneric() {
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

        int i = currSize - 1;
        while (i >= 0 && ((T) tab[i]).compareTo(value) > 0) {
            tab[i + 1] = tab[i];
            i--;
        }
        tab[i + 1] = value;
        currSize++;
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

    public int indexOf(T value) {
        int left = 0;
        int right = currSize - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = ((T) tab[mid]).compareTo(value);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[ ");
        for (int i = 0; i < this.currSize; i++) {
            text.append(tab[i]).append(" ");
        }
        return text.append("]").toString();
    }
}
