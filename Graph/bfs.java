package Graph;

import java.util.*;

public class bfs {
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;

        }
    }

    static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[], int V) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // Source = 0
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + "--->");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        bfs(graph, V);
    }
}

/////<-------ALGORITHM------->////////
// Initialization:

// Create a boolean array visited[] to keep track of which vertices have been visited. This prevents revisiting nodes and getting stuck in cycles.
// Initialize a queue (using LinkedList) to facilitate the BFS traversal. The queue will hold the vertices to be explored.
// Starting Point:

// Add the starting vertex (in this case, vertex 0) to the queue.
// Traversal:

// While the queue is not empty:
// Remove the front vertex from the queue (let's call it curr).
// Check if curr has already been visited:
// If not, mark it as visited and print it (or process it as needed).
// For each edge connected to curr (i.e., for each neighbor of curr):
// Add the destination vertex of the edge to the queue for future exploration.