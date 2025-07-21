import java.util.*;

public class medianof2sorted {
    public double findmediansortedarray(int [] nums1,int []nums2){
        ArrayList<Integer> reslist = new ArrayList<>();
        for(int num :nums1){
            reslist.add(num);
        }
        for(int num :nums2){
            reslist.add(num);
        }
        Collections.sort(reslist);
        int n = reslist.size();
        if(n%2==0){
            return (reslist.get(n/2)+reslist.get(n/2-1))/2.0;
        }
        else{
            return reslist.get(n/2);
        }
    }  
    public static void main(String[] args) {
        medianof2sorted obj = new medianof2sorted();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median of the two sorted arrays: " + obj.findmediansortedarray(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median of the two sorted arrays: " + obj.findmediansortedarray(nums3, nums4));
        int []nums5 = {1, 2, 3, 4, 5};
        int []nums6 ={5,4,9,2,1};
        System.out.println("Median of the two sorted arrays: " + obj.findmediansortedarray(nums5, nums6));
    }  
}
