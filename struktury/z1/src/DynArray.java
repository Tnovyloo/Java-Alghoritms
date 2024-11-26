public class DynArray {
    public static int DEFAULT_INITIAL_CAPACITY = 4;
    private int[] tab;
    private int currSize;

    public DynArray(int initialCapacity) {
        this.tab = new int[initialCapacity];
        this.currSize = 0;
    }

    public DynArray() {
        this.tab = new int[DEFAULT_INITIAL_CAPACITY];
        this.currSize = 0;
    }

    private void increaseCapacityIfNeeded() {
        if (this.tab.length == this.currSize) {
            int[] newTab = new int[this.tab.length * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
    }

    public int size() {
        return this.currSize;
    }

    public void add(int value) {
        this.increaseCapacityIfNeeded();

        this.tab[this.currSize] = value;
        this.currSize++;
    }

    public void add(int value, int index) {
        if (index < 0 || index >= this.currSize)
            throw new IndexOutOfBoundsException();

        this.increaseCapacityIfNeeded();

        System.arraycopy(this.tab, index, this.tab, index + 1, this.currSize - index);
        this.tab[index] = value;
        this.currSize++;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.currSize)
            throw new IndexOutOfBoundsException();

        System.arraycopy(this.tab, index + 1, this.tab, index, this.currSize - index - 1);
        this.currSize--;
    }

    public int indexOf(int value) {
        if (this.currSize == 0)
            return -1;

        for (int i = 0; i < this.currSize; i++) {
            if (this.tab[i] == value)
                return i;
        }

        return -1;
    }

    @Override
    public String toString() {
        String text = "[ ";

        for (int i = 0; i < this.currSize; i++) {
            text += tab[i] + " ";
        }

        return text + "]";
    }

    public static void main(String[] args) {
        DynArray arr = new DynArray(2);
        arr.add(1);
        arr.add(2);
        arr.add(99, 1);
        arr.add(98, 1);
        arr.add(97, 0);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);


        int index = arr.indexOf(13);
        System.out.println(index);
    }
}
 