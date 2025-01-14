// Binary Search Tree implementation in Java
class BinarySearchTree {

    // Node class representing each node in the BST
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    // Root of the BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Helper method for inserting a key recursively
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search for a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Helper method for searching a key recursively
    boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Perform an in-order traversal of the BST
    void inOrder() {
        inOrderRec(root);
    }

    // Helper method for in-order traversal
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print in-order traversal
        System.out.println("In-order traversal of the BST:");
        bst.inOrder();
        System.out.println();

        // Search for keys
        System.out.println("Search for 40: " + bst.search(40)); // Output: true
        System.out.println("Search for 25: " + bst.search(25)); // Output: false
    }
}
