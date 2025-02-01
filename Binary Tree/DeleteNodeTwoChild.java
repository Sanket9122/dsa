import java.util.*;
public class DeleteNodeTwoChild {
    static class Node {
        int data; 
        Node right,left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    //insert the node in the binary search tree
    static Node insert(Node root, int data) {

        if(root == null) 
        {
            return new Node(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }

        else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;

    }
    //finding the minimum value in the right subtree
    static int minValue(Node root){
        int minValue = root.data;
        while(root.left != null){
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    //deleting the node 
    static Node deleteNode (Node root , int data){
        if(root == null) return root;
        //deleting the node with no children
        if(data < root.data) root.left = deleteNode(root.left, data);
        else if(data > root.data) root.right = deleteNode(root.right, data);
        //deleting the node with single children
        else{
            if(root.left ==null){
                return root.right;
            }
            else if(root.right ==null){
                return root.left;
            }
            //Node with two childNode :inorder successor (smallest element in the right subtree)
            root.data = minValue(root.right);
            //delete the inorder successor 
            root.right = deleteNode(root.right, data);

        }
        return root;
    }
    //Inorder traversal in Binary search tree
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        inorder(root);
        System.out.println();
        root = deleteNode(root, 7);
        inorder(root);
    }
}
