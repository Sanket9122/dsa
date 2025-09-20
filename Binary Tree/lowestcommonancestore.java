import java.util.*;
public class lowestcommonancestore {
    static class node {
        int data ; 
        node left ; 
        node right ; 
        node(int data){
            this.data = data ; 
            this.left = null ; 
            this.right = null ; 
        }
    }
    public node LCA(node root , node p , node q){
        if(root==null){
            return null ;
        }
        while(root!=null){
            if(p.data >root.data && q.data > root.data){
                root = root.right ;
            }
            else if(p.data < root.data && q.data < root.data){
                root = root.left ;
            }
            else{
                return root ;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        lowestcommonancestore obj = new lowestcommonancestore();
        node root = new node(6);
        root.left = new node(2);
        root.right = new node(8);
        root.left.left = new node(0);
        root.left.right = new node(4);
        root.right.left = new node(7);
        root.right.right = new node(9);
        root.left.right.left = new node(3);
        root.left.right.right = new node(5);
        node p = root.left ; 
        node q = root.right ; 
        System.out.println(obj.LCA(root, p, q).data); 
        node p1 = root.left ; 
        node q1 = root.left.right ; 
        System.out.println(obj.LCA(root, p1, q1).data); 
    }
}
