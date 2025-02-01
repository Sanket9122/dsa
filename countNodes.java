public class countNodes {
    static class Node{
        int data;
        Node left;
        Node right;


        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int left = countNodes(root.left);
        int right =countNodes(root.right);

        int count = 1 + left + right;
        return count;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(countNodes(root));
    }
}
