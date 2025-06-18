import java.util.*;
public class subarraysum{
    public static int subarraysum(int[]nums ,int k){
        int result = 0 ;
        int currsum = 0 ;
        int rmvsum =  0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int num :nums){
            currsum += num; 
            rmvsum = currsum - k;
            if(map.containsKey(rmvsum)){
                result += map.get(rmvsum);
            }
            map.put(currsum,map.getOrDefault(currsum,0)+1);

        }
        return result;
     }
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraysum(nums,k)); 
        int nums1[] = {1,2,3};
        int k1 = 3;
        System.out.println(subarraysum(nums1,k1)); 
        int nums2[] = {0,0,0,0,1};
        int k2 = 2;
        System.out.println(subarraysum(nums2,k2)); 
}
}
