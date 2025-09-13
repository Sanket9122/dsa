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

    int count , result;
    public int bstkthlargestfinder2(node root2, int k2){
        if(root2==null){
            return -1;
        }
        count = k2;
        bstfinderhelper(root2);
        return result;
    }
    public int bstfinderhelper(node root2){
        if(root2==null){
            return -1;
        }
        bstfinderhelper(root2.right);
        count--;
        if(count==0){
            result = root2.val;
            return result;
        }
        bstfinderhelper(root2.left);
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
        findkthlargestelement obj2 = new findkthlargestelement();
        node root2 = new node(10);
        root2.left = new node(5);
        root2.right = new node(15);
        root2.left.left = new node(2);
        root2.left.right = new node(7);
        root2.right.right = new node(20);
        int k2 = 2;
        System.out.println(obj2.bstkthlargestfinder2(root2, k2));
    }
}
