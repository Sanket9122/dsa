
import java.util.*;
public class sumofnodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.right = null;
            this.left=null;
        }
    }
    public static int sumofnodes(Node root){
        if(root==null){
            return 0;
        }
        int right =sumofnodes(root.right);
        int left =sumofnodes(root.left);
        return root.data+right+left;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(sumofnodes(root));
    }    
}
