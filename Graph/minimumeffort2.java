package Graph;
import java.util.*;
public class minimumeffort2 {
    static class Node {
        int row ,col,dist;
        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public static int minimumeffort (int [][] heights ){
        int m  = heights.length;
        int n = heights[0].length;
        int [][] effort = new int[m][n];
        int [] dx = {-1,0,1,0};
        int [] dy = {0,1,0,-1};
        for (int i = 0; i < m; i++) {
            Arrays.fill(effort[i],Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.row;
            int y = curr.col;
            int currenteffort = curr.dist;
            if (x == m - 1 && y == n - 1) {
                return currenteffort;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {   
                    int newEffort = Math.max(currenteffort, Math.abs(heights[nx][ny] - heights[x][y]));
                    if (newEffort < effort[nx][ny]) {
                        effort[nx][ny] = newEffort;
                        q.offer(new Node(nx,ny,newEffort));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumeffort(heights)); 
    }
}

