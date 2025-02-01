// import java.util.*;
// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//         left = right = null;
//     }
// }
// class BinaryTreeToBST {
//     static Node root;
//     // Function to convert a Binary Tree to a Binary Search Tree
//     static Node convertBST(Node root) {
//         if (root == null)
//             return root;
//         // Convert the left subtree to BST
//         convertBST(root.left);
//         // Convert the right subtree to BST
//         convertBST(root.right);
//         // Inorder traversal of the tree and insertion of nodes into a list
//         List<Integer> nodes = new ArrayList<>();
//         inorderTraversal(root, nodes);
//         // Sort the list in ascending order
//         Collections.sort(nodes);
//         // Convert the tree back to a BST using the sorted list
//         int i = 0;
//         bstConversion(root, nodes, i);
//         return root;
//     }
//     // Function to perform inorder traversal of the tree and insert nodes into a list
//     static void inorderTraversal(Node root, List<Integer> nodes) {
//         if (root == null)
//             return;
//         inorderTraversal(root.left, nodes);
//         nodes.add(root.data);
//         inorderTraversal(root.right, nodes);
//     }
//     // Function to convert the tree back to a BST using the sorted list
//     static void bstConversion(Node root, List<Integer> nodes, int i) {
//         if (root == null)
//             return;
//         bstConversion(root.left, nodes, i++);
//         root.data = nodes.get(i);
//         bstConversion(root.right, nodes, i++);
//     }
//     // Function to print the Binary Search Tree
//     static void printBST(Node root) {
//         if (root == null)
//             return;
//         printBST(root.left);
//         System.out.print(root.data + " ");
//         printBST(root.right);
//     }
//     public static void main(String[] args) {
//         BinaryTreeToBST tree = new BinaryTreeToBST();
//         // Construct the Binary Tree
//         tree.root = new Node (10);
//         tree.root.left = new Node(30);
//         tree.root.right = new Node(15);
//         tree.root.left.left = new Node(5);
//         tree.root.left.right = new Node(20);
        
//         // Convert the Binary Tree to a Binary Search Tree
//         tree.root = convertBST(tree.root);
        
//         // Print the Binary Search Tree
//         System.out.println("Inorder traversal of the converted BST:");
//         printBST(tree.root);
//     }
// }

import java.util.*;

public class BinarytreeToBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root;

    // Convert Binary Tree to BST
    static Node convertBST(Node root) {
        if (root == null) return root;

        // Step 1: Perform an inorder traversal to collect node values
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        // Step 2: Sort the collected values
        Collections.sort(nodes);

        // Step 3: Reassign values to the tree using a shared index
        int[] index = {0}; // Use an array to hold the index
        bstConversion(root, nodes, index);

        return root;
    }

    // Inorder traversal to collect values from the tree
    static void inorderTraversal(Node root, List<Integer> nodes) {
        if (root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root.data);
        inorderTraversal(root.right, nodes);
    }

    // Convert tree nodes to BST using sorted values
    static void bstConversion(Node root, List<Integer> nodes, int[] index) {
        if (root == null) return;
        bstConversion(root.left, nodes, index);
        root.data = nodes.get(index[0]++);
        bstConversion(root.right, nodes, index);
    }

    // Print BST in inorder
    static void printBST(Node root) {
        if (root == null)
            return;
        printBST(root.left);
        System.out.print(root.data + " ");
        printBST(root.right);
    }

    public static void main(String[] args) {
        BinarytreeToBST tree = new BinarytreeToBST();

        // Construct the Binary Tree
        tree.root = new Node(10);
        tree.root.left = new Node(30);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(20);

        // Convert the Binary Tree to a Binary Search Tree
        tree.root = convertBST(tree.root);

        // Print the Binary Search Tree
        System.out.println("Inorder traversal of the converted BST:");
        printBST(tree.root);
    }
}
