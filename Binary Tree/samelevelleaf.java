import java.util.*;

public class samelevelleaf {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private int leafLevel = -1;

    public boolean issamelevel(Node root) {
        return checkleaves(root, 0);
    }

    private boolean checkleaves(Node root, int level) {
        if (root == null) {
            return true; // Base case: Null node is valid
        }

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            if (leafLevel == -1) {
                // First leaf node found, set its level
                leafLevel = level;
            }
            return leafLevel == level; // Check if the level matches
        }

        // Recurse for left and right subtrees
        return checkleaves(root.left, level + 1) && checkleaves(root.right, level + 1);
    }

    public static void main(String[] args) {
        samelevelleaf tree = new samelevelleaf();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(tree.issamelevel(root)); // Output: true

        Node unbalancedRoot = new Node(1);
        unbalancedRoot.left = new Node(2);
        unbalancedRoot.left.left = new Node(3);
        System.out.print(tree.issamelevel(unbalancedRoot)); // Output: false
    }
}
