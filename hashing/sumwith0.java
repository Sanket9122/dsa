package hashing;
import java.util.*;
public class sumwith0 {
    public static int sumwith0(int []arr){
        int sum =0;
        HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
        int max_len = 0;
        for (int i = 0 ; i<arr.length ; i++){
            sum += arr[i];
            if (sum == 0 ){
                max_len = i+1;
            }
            if(map.containsKey(sum)){
                max_len = Math.min(max_len, i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return max_len;
    }
    public static void main(String[] args) {
        int []arr = {1,-2,3,0,1,-3,1,1,0,1,0,1,0,1};
        int []arr2 = {15,-2,2,-8,1,7,10,23};
        System.out.println(sumwith0(arr));
        System.out.println(sumwith0(arr2));
    }
}
