package Graph;
import java.util.*;

public class minimumeffort {
    class Node {
        int row;
        int col;
        int dist;

        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int minimumEffortPath(int[][] heights, int rows, int cols) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dist = new int[rows][cols];
        boolean[][] vis = new boolean[rows][cols];

       
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new minimumeffort().new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int d = curr.dist;
            if (vis[row][col]) continue; 
            vis[row][col] = true;

           
            if (row == rows - 1 && col == cols - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dirs[i][0];
                int nc = col + dirs[i][1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[row][col]));
                    if (!vis[nr][nc] && newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        pq.add(new minimumeffort().new Node(nr, nc, newDist));
                    }
                }
            }
        }
        return -1;  
    }
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}}; 
        int rows = heights.length;
        int cols = heights[0].length;
        int result = minimumEffortPath(heights, rows, cols);
        System.out.println("Minimum Effort Path: " + result);
    }
}
