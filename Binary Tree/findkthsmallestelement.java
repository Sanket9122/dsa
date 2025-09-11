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
    int count ;
    int result;
    public int bstkthfinder2(Node root2 , int k2){
        if(root2==null){
            return -1;
        }
        count = k2 ; 
        bstfinderhelper(root2);
        return result;
    }
    public int bstfinderhelper(Node root2){
        if(root2==null){
            return -1;
        }
        bstfinderhelper(root2.left);
        count--;
        if(count==0){
            result = root2.val;
            return result;
        }
        bstfinderhelper(root2.right);
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

        findkthsmallestelement obj2 = new findkthsmallestelement();
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(14);
        root2.left.left = new Node(2);
        root2.left.right = new Node(9);
        root2.right.right = new Node(21);
        int k2 = 1;
        System.out.println(obj2.bstkthfinder2(root2, k2));
    }
}
