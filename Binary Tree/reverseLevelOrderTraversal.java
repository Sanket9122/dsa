import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class reverseLevelOrderTraversal {
    public List<Integer> reverseLevelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stack.push(node.val);

            // Enqueue right child first, so that left child is processed first
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }

        // Pop elements from the stack to get them in reverse level order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        reverseLevelOrderTraversal traversal = new reverseLevelOrderTraversal();
        List<Integer> result = traversal.reverseLevelOrder(root);
        System.out.println(result); // Output: [4, 5, 6, 7, 2, 3, 1]
    }
}