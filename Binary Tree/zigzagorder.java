import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class zigzagorder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (leftToRight) {
                    TreeNode node = deque.pollFirst();
                    level.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    TreeNode node = deque.pollLast();
                    level.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
            }

            result.add(level);
            leftToRight = !leftToRight; 
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> zigzagOrder = zigzagLevelOrder(root);

        for (List<Integer> level : zigzagOrder) {
            System.out.println(level);
        }
    }
}
