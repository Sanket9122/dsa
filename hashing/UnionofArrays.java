package hashing;
import java.util.*;
public class UnionofArrays {
    public static void union(int []a,int []b){
        HashSet<Integer> hash  = new HashSet<Integer>();
        for (int num : a){
            hash.add(num);
        }
        for (int num : b){
            hash.add(num);
        }
        System.out.println(hash);
        System.out.println(hash.size());
    }
    public static void main(String[] args) {
        int []a = {1,2,3,4,5};
        int []b = {4,5,6,7,8};
        union(a,b);
    }
}


// second approach
// package hashing;
// import java.util.*;
// public class UnionofArrays {
//     public static Set<Integer> union (Set<Integer> set1 , Set<Integer> set2){
//         Set<Integer> hash = new HashSet<Integer>(set1);
//         hash.addAll(set2);
//         return hash;
//     }
//     public static void main(String[] args) {
//         Set<Integer> set1 = new HashSet<Integer>();
//         set1.add(1);
//         set1.add(2);
//         set1.add(3);
//         set1.add(4);
//         set1.add(5);
//         Set<Integer> set2 = new HashSet<Integer>();
//         set2.add(4);
//         set2.add(5);
//         set2.add(6);
//         set2.add(7);
//         set2.add(8);
//         Set<Integer> unionset = union(set1,set2);
//         System.out.println(unionset);
//         System.out.println(unionset.size());
//     }
// }
