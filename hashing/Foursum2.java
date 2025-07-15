package hashing;
import java.util.*;
public class Foursum2 {
    public int foursum(int [] nums1,int [] nums2,int [] nums3 ,int [] nums4){
        HashMap<Integer ,Integer > resmap = new HashMap<>();
        int count = 0 ;
        for(int a :nums1){
            for(int b :nums2){
                int key = a+b;
                resmap.put(key,resmap.getOrDefault(key,0)+1);
            }
        }
        for(int c :nums3){
            for(int d : nums4){
                int key = - (c+d);
                if(resmap.containsKey(key)){
                    count = count + resmap.getOrDefault(key,0);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Foursum2 foursum2 = new Foursum2();
        int [] nums1 = {1,2};
        int [] nums2 = {-2,-1};
        int [] nums3 = {-1,2};
        int [] nums4 = {0,2};
        System.out.println(foursum2.foursum(nums1,nums2,nums3,nums4));
    }
}
