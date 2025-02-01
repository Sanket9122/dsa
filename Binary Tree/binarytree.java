import java.util.*;
public class binarytree{
    static class Node {
        int data;
        Node left;
        Node right;



        Node  (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buidTree(int [] node){

            idx++;
            if(node[idx]==-1){
                return null;
            }
            Node newnode = new Node(node[idx]);
            newnode.left = buidTree(node);
            newnode.right = buidTree(node);
            return newnode;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data +"");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {

        int [] node = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buidTree(node); 
        System.out.println(root.data);
       
        }
}