package Graph;
import java.util.*;
public class shortestpath2 {
    public static int [] shortestpath(int src ,ArrayList<ArrayList<Integer>> list) {
        int n = list.size();
        int [] dist = new int [n];
        Arrays.fill(dist , -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while (!q.isEmpty()) {
            int node  = q.poll();
            for (int it : list.get(node)){
                if(dist[it] == -1){
                    dist[it] = dist[node] + 1 ;
                    q.add(it);
                }
            }
    }
    return dist ; 
}
public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int n = 4;
    for (int i = 0; i < n; i++) {
        list.add(new ArrayList<>());
    }
    list.get(0).add(1);
    list.get(0).add(2);
    list.get(1).add(2);
    list.get(2).add(0);
    list.get(2).add(3);
    list.get(3).add(3);
    int [] dist = shortestpath(0 , list);
    for (int i = 0; i < dist.length; i++) {
        System.out.print(dist[i] + " ");
    }

}
}
