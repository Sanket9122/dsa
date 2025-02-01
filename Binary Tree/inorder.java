import java.util.*;
public class inorder {
    static class Node{
        int data;
        Node left;
        Node right;


        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Tree{
        static int i =-1;
        static Node insert(int []nodes){
            if(nodes[i]==-1){
                return null;
            }
            Node root = new Node(nodes[i]);
            root.left=insert(nodes);
            root.right=insert(nodes);
            return root;
        }
    }
    public static void inordertraversal(Node nn){
        if(nn==null){
            return;
        }
        inordertraversal(nn.left);
        System.out.print(nn.data);
        inordertraversal(nn.right);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inordertraversal(root);
    }
}
