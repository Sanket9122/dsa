public class DeleteNodeWithOneChild {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.val) {
            root.left = insertNode(root.left, key);
        } else if (key > root.val) {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    public static Node deleteNodeWithOneChild(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNodeWithOneChild(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNodeWithOneChild(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
        }
        return root;
    }
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 5);
        root = insertNode(root, 3);
        root = insertNode(root, 7);
        root = insertNode(root, 2);
        root = insertNode(root, 4);
        root = insertNode(root, 6);
        inorder(root);
        System.out.println();
        root = deleteNodeWithOneChild(root, 7);
        inorder(root);
    }
}
