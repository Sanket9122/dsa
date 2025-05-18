public class kthmissing {
    public int kthmiss(int [] arr , int  k ){
        int n =arr.length ; 
        int left = 0;
        int right = n ;
        while(left < right){
            int mid = left + (right - left)/2;
            int missing =  arr[mid] - (mid+1);
            if (missing <k){
                left  = mid +1;
            }
            else{
                right = mid ; 
            }
        }
        if (left == 0 ){
            return k;
        }
        else{
            int missingbeforeleft = arr[left-1] - (left);
            return arr[left-1] + (k - missingbeforeleft);
        }
    }
    public static void main(String[] args) {
        kthmissing k = new kthmissing();
        int arr[] = {2,3,4,7,11};
        int arr1[] = {1,2,3,4};
        int arr2[] = {5,6,7,8};
        System.out.println(k.kthmiss(arr , 5)); 
        System.out.println(k.kthmiss(arr1 , 2)); 
        System.out.println(k.kthmiss(arr2 , 3)); 
    }
}
