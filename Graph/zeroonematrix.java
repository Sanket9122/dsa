package Graph;
import java.util.*;
public class zeroonematrix {
    // public static int [][] updatedmatrix(int [][] grid){
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int [] [] updated = new int [m][n];
    //     Queue<int []>q = new LinkedList<>();
    //     for(int i = 0; i < m; i++){
    //         for (int j = 0; j < n; j++){
    //             if (grid[i][j] == 0){
    //                 updated[i][j]=0;
    //                 q.offer(new int [] {i,j});
    //             }
    //             else{
    //                 updated[i][j] = Integer.MAX_VALUE;
    //             }
    //         }
    //     }
    //     int [] directions  =  {-1, 0, 1, 0, 0, -1, 0, 1};
    //     while(!q.isEmpty()){
    //         int [] curr = q.poll();
    //         int r= curr[0];
    //         int c= curr[1];
    //         for (int i = 0;i<4;i++){
    //             int x = r+ directions[i];
    //             int y = c+directions[i+1];
    //             if(x>=0 && x<m && y>=0 && y<n && updated[x][y]>updated[r][c]+1){
    //                 updated[x][y] = updated[r][c]+1;
    //                 q.offer(new int [] {x,y});
    //             }
    //         }
    //     }
    //     return updated;
    //     }
    //     public static void main(String[] args) {
    //         int [][] grid = {{0,0,0},{0,1,0},{0,0,0}};
    //         int [][] updated = updatedmatrix(grid);
    //         for (int i = 0; i < updated.length; i++) {
    //             for (int j = 0; j < updated[i].length; j++) {
    //                 System.out.print(updated[i][j] + " ");
    //             }
    //             System.out.println();
    //         }

    //     }
    static int [][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; 
        int [][] result  = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int []dirs = {-1, 0, 1, 0, 0, -1, 0, 1};
        for (int i = 0 ; i< m ;i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j] == 0) {
                    for (int k = 0 ; k < 4 ; k++) {
                        int x = i + dirs[k];
                        int y = j + dirs[k+1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            result[x][y] = Math.min(result[x][y], result[i][j] + 1);
                        }
                    }

                }

            }

        }
        return result;
    }
    public static void main(String[] args) {
        int [][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        int [][] result = updateMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();           
        }
    }

    } 

