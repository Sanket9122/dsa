import java.util.*;
public class TwosumIV {
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
    public boolean findtarget(node root , int k){
        HashSet<Integer> vis = new HashSet<>();
        return findpair(root , k , vis);
    }
    public boolean findpair(node root , int k , HashSet<Integer> vis){
        if(root == null){
            return false ; 
        }
        if(vis.contains(k - root.data)){
            return true ; 
        }
        vis.add(root.data);
        return findpair(root.left , k , vis) || findpair(root.right , k , vis);
    }
    public static void main(String[] args) {
        TwosumIV obj = new TwosumIV();
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(6);
        root.left.left = new node(2);
        root.left.right = new node(4);
        root.right.right = new node(7);
        int k = 9;
        System.out.println(obj.findtarget(root, k)); 
        int k1 = 28;
        System.out.println(obj.findtarget(root, k1)); 
    }
}
