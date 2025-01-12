public class LinkedList {
    private Node head;
    
    public LinkedList() {
        head = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        } 

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }

        if (index == 0) {
            if (head.next != null) {
                head = head.next;
            }
            return;
        }

        Node prev = null;
        Node current = head;

        int i = 1;
        while (current.next != null) {
            prev = current;
            current = current.next;
            if (i == index) {
                if (current.next != null) {
                    prev.next = current.next;
                } else if (current.next == null) {
                    prev.next = null;
                }
            }

            i++;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Display the list
        System.out.println("Linked List:");
        list.display();

        list.add(100);
        list.add(50);
        list.add(99);

        list.display();
        list.remove(4);
        // list.remove(0);
        list.display();
        list.remove(5);
        list.display();

    }
}
