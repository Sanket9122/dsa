import java.util.*;
public class findkthsmallestelement {
    static class Node {
        int val ; 
        Node left ,right ; 
        Node(int val){
            this.val = val ;
            this.left = null ;
            this.right = null;
        }
    }
    public int bstkthfinder(Node root , int k){
        Stack<Node> st = new Stack<Node>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
    public static void main(String[] args) {
        findkthsmallestelement obj = new findkthsmallestelement();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.right = new Node(20);
        int k = 3;
        System.out.println(obj.bstkthfinder(root, k));
    }
}
