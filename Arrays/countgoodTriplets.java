 
import java.util.*;
public class countgoodTriplets{
    public int goodtriplets(int []arr ,int a,int b,int c){
        int n = arr.length ; 
        int count =  0; 
        for(int i  = 0 ; i <n ;i++){
            for(int j = i+1 ; j<n ;j++){
                for(int k =j+1 ; k<n;k++){
                    int abs_ij = Math.abs(arr[i]-arr[j]);
                    int abs_jk = Math.abs(arr[j]-arr[k]);
                    int abs_ik = Math.abs(arr[i]-arr[k]);
                    if(abs_ij<a && abs_jk<b && abs_ik<c){
                        count++;
                    }
                }
            }
        }
        return count ;
    }
    public static void main(String[] args) {
        countgoodTriplets obj = new countgoodTriplets();
        int []arr = {1,2,3,4,5};
        int [] arr1 = {3,0,1,1,9,7};
        System.out.println(obj.goodtriplets(arr,1,2,5));
        System.out.println(obj.goodtriplets(arr1,7,2,3));  
    }
}