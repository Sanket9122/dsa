import java.util.*;
public class mirrortree {
    static class Node {
        int data;
        Node left ,right;
        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static void inorder(Node root){
        if(root == null)     return ;
        inorder(root.left);
        System.out.print(root.data +"------>");
        inorder(root.right);
    }
    public static Node mirrortree (Node root){
        if(root == null){
            return null;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrortree(root.left);
        mirrortree(root.right);
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root = mirrortree(root);
        inorder(root);
    }
}
