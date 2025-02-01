import java.util.*;

public class levelordertraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree {
        static int idx = -1;

        public static Node buildtree(int[] nodes) {
            if (nodes[idx] == -1) {
                return null;
            }
            idx++;
            Node nn = new Node(nodes[idx]);
            nn.left = buildtree(nodes);
            nn.right = buildtree(nodes);
            return nn;
        }
    }

    public static void levelorder(Node rt) {
        if (rt == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(rt);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        levelorder(root);
    }
}
