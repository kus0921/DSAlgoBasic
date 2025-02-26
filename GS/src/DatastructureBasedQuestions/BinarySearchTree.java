package DatastructureBasedQuestions;
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Insert method
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert function
    Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search method
    boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive search function
    boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Inorder traversal (Left -> Root -> Right)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public class BSTExample {
        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();

            // Insert nodes
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);

            // Print inorder traversal (sorted order)
            System.out.print("Inorder Traversal: ");
            bst.inorder(); // Output: 20 30 40 50 60 70 80

            // Search for a value
            System.out.println("\nIs 40 in BST? " + bst.search(40)); // Output: true
            System.out.println("Is 100 in BST? " + bst.search(100)); // Output: false
        }
    }

}
