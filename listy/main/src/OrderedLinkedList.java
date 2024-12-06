public class OrderedLinkedList<T extends Comparable<T>> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public void insert(T value) {
        Node<T> insertedNode = new Node<>(value);

        if (this.size == 0) {
            // Proste wstawienie, jeśli lista jest pusta
            this.first = insertedNode;
            this.last = insertedNode;
        } else {
            Node<T> insNext = this.first;
            int insNextIndex = -1;

            for (int i = 0; i < this.size; i++) {
                if (insNext.value.compareTo(value) > 0) {
                    insNextIndex = i;
                    break;
                }
                insNext = insNext.next;
            }

            if (insNextIndex == -1) {
                // Wstawienie na końcu
                Node<T> prevLast = this.last;
                this.last = insertedNode;

                insertedNode.prev = prevLast;
                prevLast.next = insertedNode;
            } else if (insNextIndex == 0) {
                // Wstawienie na początku
                Node<T> prevFirst = this.first;
                this.first = insertedNode;

                insertedNode.next = prevFirst;
                prevFirst.prev = insertedNode;
            } else {
                // Wstawienie na środku
                Node<T> newPrev = insNext.prev;

                insertedNode.prev = newPrev;
                newPrev.next = insertedNode;

                insertedNode.next = insNext;
                insNext.prev = insertedNode;
            }
        }

        this.size++;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder("[ ");
        if (size == 0)
            return txt.append("]").toString();

        Node<T> currNode = this.first;
        for (int i = 0; i < this.size; i++) {
            txt.append(currNode.value).append(" ");
            currNode = currNode.next;
        }

        return txt.append("]").toString();
    }

    public static void main(String[] args) {
        OrderedLinkedList<Person> list = new OrderedLinkedList<>();
        list.insert(new Person("Alicja", 30));
        list.insert(new Person("Borubar", 25));
        list.insert(new Person("Chorąży", 25));
        list.insert(new Person("Karolina", 20));
        list.insert(new Person("Tytus", 30));

        System.out.println(list);
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }
}
