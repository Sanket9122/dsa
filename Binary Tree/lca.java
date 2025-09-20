import java.util.* ;
public class lca {
    class node {
        int val ; 
        node left,right;
        node(int val){
            this.val = val ; 
            this.left = null ; 
            this.right = null ; 
        }
    }
    public node lowestcommonancestor(node root ,node p ,node q){
        if (root == null){
            return null;
        }
        return ancestorfinder(root,p,q);
    }
    public node ancestorfinder(node root , node p ,node q){
        if(p.val < root.val && q.val < root.val){
            return ancestorfinder(root.left , p , q);
        }
        else if(p.val > root.val && q.val > root.val){
            return ancestorfinder(root.right , p , q);
        }
        else{
            return root ;
        }
    }
    public static void main(String[] args) {
        lca obj = new lca();
        node root = obj.new node(6);
        root.left = obj.new node(2);
        root.right = obj.new node(8);
        root.left.left = obj.new node(0);
        root.left.right = obj.new node(4);
        root.right.left = obj.new node(7);
        root.right.right = obj.new node(9);
        root.left.right.left = obj.new node(3);
        root.left.right.right = obj.new node(5);
        node p = root.left ; 
        node q = root.right ; 
        System.out.println(obj.lowestcommonancestor(root, p, q).val); 
        node p1 = root.left ; 
        node q1 = root.left.right ; 
        System.out.println(obj.lowestcommonancestor(root, p1, q1).val);
    }
}
