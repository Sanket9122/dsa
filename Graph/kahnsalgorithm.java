// package Graph;
// import java.util.*;
// public class kahnsalgorithm {
//     public static int[] topologicalSort(
//         List<List<Integer> > adj, int V)
//     {
//         // Array to store indegree of each vertex
//         int[] indegree = new int[V];
//         for (int i = 0; i < V; i++) {
//             for (int it : adj.get(i)) {
//                 indegree[it]++;
//             }
//         }

//         // Queue to store vertices with indegree 0
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < V; i++) {
//             if (indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }

//         int[] result = new int[V];
//         int index = 0;
//         while (!q.isEmpty()) {
//             int node = q.poll();
//             result[index++] = node;

//             // Decrease indegree of adjacent vertices as the
//             // current node is in topological order
//             for (int it : adj.get(node)) {
//                 indegree[it]--;

//                 // If indegree becomes 0, push it to the
//                 // queue
//                 if (indegree[it] == 0) {
//                     q.offer(it);
//                 }
//             }
//         }

//         // Check for cycle
//         if (index != V) {
//             System.out.println("Graph contains cycle!");
//             return new int[0];
//         }

//         return result;
//     }

//     public static void main(String[] args)
//     {
//         // Number of nodes
//         int n = 6;

//         // Edges
//         int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 },
//                           { 4, 5 }, { 5, 1 }, { 5, 2 } };

//         // Graph represented as an adjacency list
//         List<List<Integer> > adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Constructing adjacency list
//         for (int[] edge : edges) {
//             adj.get(edge[0]).add(edge[1]);
//         }

//         // Performing topological sort
//         System.out.println(
//             "Topological sorting of the graph: ");
//         int[] result = topologicalSort(adj, n);

//         // Displaying result
//         for (int i : result) {
//             System.out.print(i + " ");
//         }
//     }
// }
package Graph;
import java.util.*;

public class kahnsalgorithm {

    // Function to perform BFS and return the queue of vertices with indegree 0
    public static Queue<Integer> bfs(List<List<Integer>> adj, int V, int[] indegree) {
        // Queue to store vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        
        // Add all vertices with indegree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        return q;
    }

    // Function to perform the topological sort
    public static int[] topologicalSort(List<List<Integer>> adj, int V) {
        // Array to store indegree of each vertex
        int[] indegree = new int[V];
        
        // Calculate the indegrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        // Perform BFS to get the initial queue of vertices with indegree 0
        Queue<Integer> q = bfs(adj, V, indegree);
        
        int[] result = new int[V];
        int index = 0;

        // Process the queue and perform topological sort
        while (!q.isEmpty()) {
            int node = q.poll();
            result[index++] = node;

            // Decrease indegree of adjacent vertices
            for (int it : adj.get(node)) {
                indegree[it]--;

                // If indegree becomes 0, add it to the queue
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // Check for cycle: If not all vertices are processed, there is a cycle
        if (index != V) {
            System.out.println("Graph contains cycle!");
            return new int[0]; // Return an empty array in case of cycle
        }

        return result;
    }

    public static void main(String[] args) {
        // Number of nodes
        int n = 6;

        // Edges
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 },
                          { 4, 5 }, { 5, 1 }, { 5, 2 } };

        // Graph represented as an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Performing topological sort
        System.out.println("Topological sorting of the graph: ");
        int[] result = topologicalSort(adj, n);

        // Displaying result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

