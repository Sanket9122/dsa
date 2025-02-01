package Graph;

public class adjacencymatrix {
    public static void addeddge(int[][] graph, int src, int dest) {
        graph [src][dest] = 1;
        graph [dest][src] = 1;
    }
    public static void display(int[][] graph) {
        for (int[] row  : graph ){
            for (int value : row ){
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] graph = new int[4][4];
        addeddge(graph, 0, 1);
        addeddge(graph, 0, 2);
        addeddge(graph, 1, 2);
        addeddge(graph, 2, 3);
        display(graph);
    }
}
