public class LinkedList {
    private Node first;
    private Node last;
    private int size = 0;

    public int size() {
        return size;
    }

    public int getFirst() {
        return this.first.value;
    }

    public void insertLast(int value) {
        Node insertedNode = new Node(value);

        if (this.size == 0) {
            this.first = insertedNode;
            this.last = insertedNode;
        } else {
            Node prevLast = this.last;
            this.last = insertedNode;

            insertedNode.prev = prevLast;
            prevLast.next = insertedNode;
        }

        this.size++;
    }

    public int removeLast() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("");
        }

        int retVal = this.last.value;

        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            Node newLast = this.last.prev;
            this.last = newLast;
            newLast.next = null;
        }
        this.size--;

        return retVal;
    }

    public int indexOf(int value) {
        if (this.size == 0)
            return -1;

        Node currNode = this.first;
        for (int i = 0; i < this.size; i++) {
            if (currNode.value == value)
                return i;
            currNode = currNode.next;
        }

        return -1;
    }

    @Override
    public String toString() {
        String txt = "[ ";
        if (size == 0)
            return txt + "]";

        Node currNode = this.first;
        for (int i = 0; i < this.size; i++) {
            txt += currNode.value + " ";
            currNode = currNode.next;
        }

        return txt + "]";
    }

    // Wstawianie na początku listy
    public void insertFirst(int value) {
        Node insertedNode = new Node(value);

        if (this.size == 0) {
            this.first = insertedNode;
            this.last = insertedNode;
        } else {
            Node prevFirst = this.first;
            this.first = insertedNode;

            insertedNode.next = prevFirst;
            prevFirst.prev = insertedNode;
        }

        this.size++;
    }

    // Usuwanie pierwszego elementu
    public int removeFirst() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("Lista jest pusta.");
        }

        int retVal = this.first.value;

        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            Node newFirst = this.first.next;
            this.first = newFirst;
            newFirst.prev = null;
        }

        this.size--;

        return retVal;
    }

    // Usuwanie elementu na podanym indeksie
    public int removeAt(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Nieprawidłowy indeks.");
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node currNode = this.first;

            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }

            int retVal = currNode.value;

            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            this.size--;

            return retVal;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);

        System.out.println("Lista początkowa: " + list);

        list.insertFirst(0);
        System.out.println("Po dodaniu 0 na początek: " + list);

        System.out.println("Pierwszy element usunięty: " + list.removeFirst());
        System.out.println("Lista po usunięciu pierwszego elementu: " + list);

        System.out.println("Element usunięty na indeksie 1: " + list.removeAt(1));
        System.out.println("Lista po usunięciu elementu na indeksie 1: " + list);

        list.removeLast();
        System.out.println("Lista po usunięciu ostatniego elementu: " + list);
    }

    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
}
