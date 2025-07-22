import java.util.*;
public class Twosumpairwith0sum {
    public List<List<Integer>> find2sumpairwith0(int [] arr){
        List<List<Integer>> result = new ArrayList<>();

        int n= arr.length;
        Arrays.sort(arr);
        if(n==0 || n < 2){
            return result;
        }
        int left = 0 ; 
        int right  = n-1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum==0){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                result.add(pair);
                left++;
                right--;
                while(left < right && arr[left] == arr[left+1]){
                    left++;
                }
                while(left < right && arr[right] == arr[right-1]){
                    right--;
                }
                left++;
                right--;
            }
            else if(sum < 0){
                left++;
            }
            else{
                right--;
            }
    }
    return result;
    }
    public static void main(String[] args) {
        Twosumpairwith0sum obj = new Twosumpairwith0sum();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> result1 = obj.find2sumpairwith0(arr);
        System.out.println(result1);
    }
}
