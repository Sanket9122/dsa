import java.util.*;
public class findkthlargestelement {
    static class node {
        int val ; 
        node left,right;
        node(int val){
            this.val = val ;
            this.left = null ;
            this.right = null;
        }
    }
    public int bstkthlargestfinder(node root, int k){
        Stack<node> st = new Stack<>() ; 
        if(root == null)   return -1;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.right;
            }
            root = st.pop();
            k--;
            if(k==0){
                return root.val;
            }
            root = root.left;
        }
        return -1;
    }
    public static void main(String[] args) {
        findkthlargestelement obj = new findkthlargestelement();
        node root = new node(10);
        root.left = new node(3);
        root.right = new node(11);
        root.left.left = new node(2);
        root.left.right = new node(6);
        root.right.right = new node(19);
        int k =2;
        int k1 = 7;
        System.out.println(obj.bstkthlargestfinder(root, k));
        System.out.println(obj.bstkthlargestfinder(root, k1));
    }
}
