//maximum subarray sum using kadannes algorithm
public class kadannes {
    public static int kadn(int arr[] ){
        int max = arr[0];
        int n = arr.length;
        int sum = arr[0];
        for (int i = 1;i<n;i++){
            if (n==1 || n==0){
                return arr[0];
            }
            sum  = Math.max(sum + arr[i] , arr[i]);
            max  = Math.max (max  ,sum);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int arr1[] = {1};
        int arr2[] = {5,4,-1,7,8};
        System.out.println(kadn(arr));
        System.out.println(kadn(arr1));
        System.out.println(kadn(arr2));
    }
}