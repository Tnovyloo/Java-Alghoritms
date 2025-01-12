public class BinarySearchTree {
    Node root;

    void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = newNode;
        Node parent = current;

        while (true) {
            parent = current;

            if (value < current.value) {
                current = parent.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = parent.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
