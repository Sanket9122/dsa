package Graph;
import java.util.*;

public class adjacencylist {
    static void addeddge(List<List<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }
    static void display(List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int j : graph.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        addeddge(graph, 0, 1);
        addeddge(graph, 0, 2);
        addeddge(graph, 1, 2);
        addeddge(graph, 2, 3);
        display(graph);
    }
}
