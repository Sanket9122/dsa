package Graph;
import java.util.*;

public class rottenoranges {
    static int rottenoranges(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        if (count == 0) {
            return 0;
        }
        
        int[] directions = new int[]{-1, 0, 1, 0, 0, -1, 0, 1};
        
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            
            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    int x = rotten[0] + directions[j * 2];
                    int y = rotten[1] + directions[j * 2 + 1];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                        count--;
                    }
                }
            }
        }
        
        return count == 0 ? time : -1;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {2, 1, 1}, {1, 1, 0}, {0, 1, 1} };
        System.out.println(rottenoranges(grid));
    }
}
