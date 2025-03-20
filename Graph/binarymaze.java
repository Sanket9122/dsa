package Graph;
import java.util.*;

public class binarymaze {
    static class Node {
        int row;
        int col;
        int distance;
        
        Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    static int shortestdistance(int[][] maze, int[] src, int[] dest) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src[0], src[1], 0));
        dist[src[0]][src[1]] = 0;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == 1 && dist[nr][nc] == -1) {
                    dist[nr][nc] = curr.distance + 1;
                    
                    if (nr == dest[0] && nc == dest[1]) {
                        return dist[nr][nc];
                    }
                    
                    q.add(new Node(nr, nc, curr.distance + 1));
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        int[] src = {0, 1};
        int[] dest = {2, 2};
        
        System.out.println(shortestdistance(maze, src, dest));
    }
}
