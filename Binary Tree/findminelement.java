public class findminelement {
    static class Node {
        int val ; 
        Node right , left ; 
        Node(int val){
            this.val = val ; 
            this.right = null;
            this.left =null;
        }
    }
    public int minfinder(Node root){
        if(root==null){
            return -1;
        }
        if(root.left ==null){
            return root.val;
        }
        Node current = root; 
        while(current.left!=null){
            current = current.left;
        }
        return current.val;
    }
    public static void main(String[] args) {
        findminelement obj = new findminelement();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.right = new Node(20);
        System.out.println(obj.minfinder(root));
    }
}
