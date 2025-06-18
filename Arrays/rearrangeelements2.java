import java.util.*;
public class rearrangeelements2 {
    public static int[] rearrange(int[] arr) {
        int n = arr.length;
        int [] result = new int[n];
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        for (int num : arr) {
            if (num >= 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }
        for (int i = 0 ;  i< n/2;i++){
            result [2*i] = positives.get(i);
            result [2*i + 1] = negatives.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6};
        int[] rearrangedArray = rearrange(arr);
        System.out.println("Rearranged array: " + Arrays.toString(rearrangedArray));
    }
}