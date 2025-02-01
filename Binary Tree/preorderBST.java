import java.util.*;
public class preorderBST {
    static class Node{
        int data;
        Node left , right ;

        Node (int data){
            this.data = data;
            this.left  = null; 
            this.right =null;
        }
    }
    static class BSTINSERT{
        static Node insert(Node root , int data){
            if(root == null){
                return new Node(data);
            }

            if(data < root.data){
                root.left = insert(root.left , data);
            }
            else {
                root.right = insert(root.right , data);
            }
            
            return root;
            
        }
    static void preorder(Node root){
        if(root  == null){      return ;}

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    }
    public static void main(String[] args) {
        Node root = null;
        root = BSTINSERT.insert(root , 5);
        root = BSTINSERT.insert(root , 3);
        root = BSTINSERT.insert(root , 6);
        root = BSTINSERT.insert(root , 2);
        root = BSTINSERT.insert(root , 4);
        root = BSTINSERT.insert(root , 7);
        root = BSTINSERT.insert(root , 1);
        root = BSTINSERT.insert(root , 8);
        BSTINSERT.preorder(root);
    }
}
