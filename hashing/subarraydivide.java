package hashing;
import java.util.*;
public class subarraydivide {
    static int subarraydivide(int []arr , int n , int k){
        HashMap<Integer , Integer> dm = new HashMap<>();
        int sum = 0;
        int count =0;
        for (int num: arr){
            sum +=num;
            int rem = sum % k;
            // if (rem < 0){
            //     rem += k;
            // }
            if (rem == 0){
                count++;
            }
            if (dm.containsKey(rem)){
                count += dm.get(rem);
            }
            dm.put(rem , dm.getOrDefault(rem , 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int []arr = {4,5,0,-2,-3,1,4}; // 5
        int n = arr.length;
        int k = 5;
        System.out.println(subarraydivide(arr , n , k));
    }
}
