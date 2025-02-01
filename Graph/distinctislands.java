package Graph;
import java.util.*;
public class distinctislands {
    public int distinctislandsnum(int [][]grid ){
        HashSet<String> disland = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i< m ;i++){
            for (int j = 0; j< n ;j++){
                if (grid[i][j] == 1) {
                    Set <String> shape  = new HashSet<>();
                    dfs(i,j,i,j,grid,shape);
                    disland.add(shape.toString());
                }
            }
        }
        return disland.size();
    }
    int[] directionsX = {0, 1, 0, -1};
    int[] directionsY = {1, 0, -1, 0};
    private void dfs(int x , int y ,int ox , int oy , int [][]grid  ,Set<String> shape){
        grid[x][y]=0;
        shape.add(x-ox +" "+(y-oy));
        for (int i = 0; i < 4; i++) {
            int newX = x + directionsX[i];
            int newY = y + directionsY[i];
            
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                dfs(newX, newY, ox, oy, grid, shape);
            }
        }
    }
    public static void main(String[] args) {
        distinctislands d = new distinctislands();
        int [][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(d.distinctislandsnum(grid));

    }
}
