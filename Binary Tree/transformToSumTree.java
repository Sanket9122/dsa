import java.util.*;
public class transformToSumTree {
    static class Node {
        int val;
        Node left,right;

        Node(int val){
            this.val = val;
            this.left =this.right =null;
        }
    }
    private int sumtree(Node root){
        if(root==null)    return 0;
        int rs = sumtree(root.right);
        int ls = sumtree(root.left);
        int temp = root.val;
        root.val = rs+ls;
        return temp + root.val;
    }
    public void transform(Node root){
       sumtree(root);
    }
    public void inorder(Node root){
        if (root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root +"--->");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        transformToSumTree obj = new transformToSumTree();
        obj.transform(root);
        obj.inorder(root);
    }
}
