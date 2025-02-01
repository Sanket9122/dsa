import java.util.*;
public class balancedtree {
    Node root;
    static class Node {
        int data;
        Node left ,right;
        Node (int data){
            this.data = data;
            this.left = this.right = null ;
        }
    }
    public int isBalanced(Node root){
        if (root ==null){
            return 0;
        }
        int lh = isBalanced(root.left);
        int rh = isBalanced(root.right);
        if(lh == -1 || rh ==-1){
            return -1;
        }
        if(Math.abs(lh-rh)>1)
        return -1;        
        else
        return Math.max(lh,rh)+1;
    }
    public static void main(String[] args) {
        balancedtree bt = new balancedtree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node (30);
        bt.root.right.left = new Node(45);
        bt.root.right.right = new Node (60);
       if(bt.isBalanced(bt.root)>0)        System.out.println("Balanced");
       else            System.out.println("unbalanced");
    }
}
