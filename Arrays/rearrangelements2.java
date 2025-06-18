import java.util.*;
public class rearrangelements2 {
    public static int  [] rearrangelements(int []nums ){
        int []result = new int [nums.length];
        int pos_idx = 0;
        int neg_idx=1;
        for (int num :nums ){
            if(num >=0){
                result[pos_idx] = num;
                pos_idx += 2;
            }
            else{
                result[neg_idx] = num;
                neg_idx += 2;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int [] nums = {1, 2, -3, 4, -5, -6};
        int [] rearrangedArray = rearrangelements(nums);
        System.out.println("Rearranged array: " + Arrays.toString(rearrangedArray));
    }
}