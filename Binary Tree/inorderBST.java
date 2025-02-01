import java.util.*;
public class inorderBST {
    static class Node{
        int val;
        Node right;
        Node left;


        Node (int val){
            this.val=val;
            this.right=null;
            this.left=null;
        }
    }
    static class BST {
        static Node insert(Node root , int val){
            if(root==null){
                return  new Node(val);
            }
            if(val<root.val){
                root.left=insert(root.left,val);
            }else{
                root.right=insert(root.right,val);
            }
            return root;
        }

        static void inorder(Node root){
            if(root==null)  return ;
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
            
        }
        public static void main(String[] args) {
            Node root = null;
            root = insert(root,5);
            root=insert(root,3);
            root=insert(root,7);
            root=insert(root,2);
            root=insert(root,4);
            root=insert(root,6);
            root=insert(root,8);
            inorder(root);
        }
    } 
}
