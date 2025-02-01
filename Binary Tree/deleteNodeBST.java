import java.util.*;
public class deleteNodeBST {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        
        }
    }
  

    public static Node deleteLeafNode(Node root,int key){
        if(root==null){
            return root;
        }

        if(key<root.data){
            root.left=deleteLeafNode(root.left,key);
        }

        else if(key>root.data){
            root.right=deleteLeafNode(root.right,key);
        }
        else {
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
        }
        return root;
    }
    public static Node insertNode(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(key<root.data){
            root.left=insertNode(root.left,key);
        }
        else if(key>root.data){
            root.right=insertNode(root.right,key);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,5);
        root = insertNode(root,3);
        root = insertNode(root,7);
        root = insertNode(root,2);
        root = insertNode(root,4);
        root = insertNode(root,6);
        root = insertNode(root,8);
        inorder(root);
        System.out.println();
        root = deleteLeafNode(root,6);
        inorder(root);
    }
}
