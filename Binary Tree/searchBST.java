import java.util.*;

public class searchBST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Method to insert a value into the BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val); // Create a new node if the root is null
        }
        if (val < root.val) {
            root.left = insert(root.left, val); // Insert in the left subtree
        } else if (val > root.val) {
            root.right = insert(root.right, val); // Insert in the right subtree
        }
        return root; // Return the unchanged root pointer
    }

    // Method to search for a value in the BST
    public static boolean search(Node root, int val) {
        if (root == null) {
            return false; // Value not found
        }
        if (val < root.val) {
            return search(root.left, val); // Search in the left subtree
        } else if (val > root.val) {
            return search(root.right, val); // Search in the right subtree
        } else {
            return true; // Value found
        }
    }

    public static void main(String[] args) {
        Node root = null;

        // Insert values into the BST
        root = insert(root, 10);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 12);
        root = insert(root, 18);
        System.out.println(search(root, 15));
    }
}