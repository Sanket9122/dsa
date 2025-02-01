package hashing;

import java.util.*;
public class MajorityElements{
    public static void MajorityElements(int[] arr) {
        HashMap<Integer,Integer> me = new HashMap<Integer,Integer>();
        int n =arr.length;
        for (int i =0 ; i< n;i++){
            if (me.containsKey(arr[i])){ // key exist
                me.put(arr[i],me.get(arr[i])+1);
            }
            else{     //key doesnot exist
                me.put(arr[i],1);
            }
        }
        for (int key : me.keySet()){
            if (me.get(key)>n/2){
                System.out.println(key);
            }

        }
        // List<Integer> ans = new ArrayList<Integer>();
        // for (int i =0 ; i< n;i++){
        //     if (me.get(arr[i])>n/3){
        //          System.out.println(arr[i]);
        //     }
        //     else{
        //         continue;
        //     }
        // }
    }
    public static void main(String[] args) {
        int nums[] ={1,3,1,3,1,2,3,1,3,2,1,4,5,6};
        MajorityElements(nums);
    }
}