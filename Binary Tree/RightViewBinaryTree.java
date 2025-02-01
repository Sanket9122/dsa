import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RightViewBinaryTree {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                // If it's the last node in the current level, add it to the result
                if (i == size - 1) {
                    result.add(currentNode.val);
                }
                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        RightViewBinaryTree tree = new RightViewBinaryTree();
        List<Integer> rightView = tree.rightSideView(root);
        
        System.out.println("Right view of the binary tree: " + rightView);
    }
}