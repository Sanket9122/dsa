import java.util.*;
public class sortcolors {
    public void sortclrs(int [] nums ){
        int low =  0 ; 
        int mid  = 0;
        int high =nums.length -1;
        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        
    }
    public static void main(String[] args) {
        sortcolors sc = new sortcolors();
        int arr[] = {2,0,2,1,1,0};
        int arr1[] = {0,1,2};
        int arr2[] = {1,0,2,0,1,2};
        sc.sortclrs(arr);
        sc.sortclrs(arr1);
        sc.sortclrs(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));  
        System.out.println(Arrays.toString(arr2));
    }
}
