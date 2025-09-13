import java.util.*;

public class insertintobst {
    static class node {
        int val;
        node right, left;

        node(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    public node insertinbinarysearchtree(node root, int val) {
        if (root == null) {
            return new node(val);
        }
        if (val < root.val) {
            root.left = insertinbinarysearchtree(root.left, val);
        } else if (val > root.val) {
            root.right = insertinbinarysearchtree(root.right, val);
        }
        return root;
    }

    public void inorderTraversal(node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        insertintobst obj = new insertintobst();
        node root = new node(10);
        root.left = new node(5);
        root.right = new node(15);
        root.left.left = new node(2);
        root.left.right = new node(7);
        root.right.right = new node(20);
        
        System.out.println("Original Tree (in-order):");
        obj.inorderTraversal(root);
        System.out.println();

        int val = 13;
        node newRoot = obj.insertinbinarysearchtree(root, val);
        
        System.out.println("Tree after inserting " + val + " (in-order):");
        obj.inorderTraversal(newRoot);
        System.out.println();
    }
}