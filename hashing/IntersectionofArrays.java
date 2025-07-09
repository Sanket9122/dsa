package hashing;
import java.util.*;  
public class IntersectionofArrays {
    public static HashSet<Integer> intersection (int []a,int []b){
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> intersectionset = new HashSet<Integer>();
        for (int num : a){
            set1.add(num);
        }
        for (int num : b){
            if (set1.contains(num)){
                intersectionset.add(num);
            }
        }
        System.out.println(intersectionset.size());
        return intersectionset;
    }
    public static void main(String[] args) {
        int []a = {1, 2, 3, 4, 5 ,9};
        int []b = {4, 5, 6, 7, 8 ,9};
        System.out.println(intersection(a,b));
    }
}
// package hashing ;
// import java.util.*;
// public class IntersectionofArrays{
//     public static void intersection (int []num1,int []num2){
//         HashSet<Integer> set1 = new HashSet<Integer>();
//         HashSet<Integer> intersectionset = new HashSet<Integer>();
//         for(int num : num1){
//             set1.add(num);
//         }
//         for (int num : num2){
//             if (set1.contains(num)){
//                 intersectionset.add(num);
//             }
//         }
//         System.out.println(intersectionset.size());
//         System.out.println(intersectionset);
//     }
//     public static void main(String[] args) {
//         int []num1 = {1, 2, 3, 4, 5};
//         int []num2 = {4, 5, 6, 7, 8};
//         intersection(num1,num2);
//     }
// }