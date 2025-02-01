import java.util.*;
public class postordertraversal {
    static class Node{
        int data;
        Node leftchild;
        Node rightchild;


        Node (int data){
            this.data=data;
            this.leftchild=null;
            this.rightchild=null;

        }
    }
    static class Binarytree{
        static int idx=-1;
        public static Node insert(int []nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node nn=new Node(nodes[idx]);
            nn.leftchild=insert(nodes);
            nn.rightchild =insert(nodes);
            return nn;
        }
    }
    public static void postorder(Node root){
        if(root==null){return ;}
        postorder(root.leftchild);
        postorder(root.rightchild);
        System.out.print(root.data);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftchild = new Node(2);
        root.rightchild = new Node(3);
        root.leftchild.leftchild = new Node(4);
        root.leftchild.rightchild = new Node(5);
        postorder(root);
    }
}
