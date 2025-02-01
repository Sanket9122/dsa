package Graph;
import java.util.*;

public class FloodFill {
    static int[][] floodfill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int ogcolor = image[sr][sc];
        if (ogcolor == newColor) {
            return image;
        }
        dfs(image, sr, sc, ogcolor, newColor);
        return image;
    }

    static void dfs(int[][] image, int sr, int sc, int ogcolor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != ogcolor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, ogcolor, newColor);
        dfs(image, sr - 1, sc, ogcolor, newColor);
        dfs(image, sr, sc + 1, ogcolor, newColor);
        dfs(image, sr, sc - 1, ogcolor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        floodfill(image, sr, sc, newColor); 
        
        // Print the updated image array properly
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
