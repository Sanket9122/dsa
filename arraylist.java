import java.util.ArrayList;
import java.util.Scanner;

public class  arraylist{
    public static void main(String[] args) {
        int i ;
      Scanner size=new Scanner(System.in);
        System.out.println("enter the size of a box:");
       int a=size.nextInt();
        ArrayList<Integer>arr1=new ArrayList<Integer>(a);
        ArrayList<Integer>arr2=new ArrayList<Integer>(a);
        ArrayList<Integer>arr3=new ArrayList<Integer>();
        ArrayList<Integer>arr4=new ArrayList<Integer>();
        System.out.println("array1:"+arr1);
        System.out.println("array2:"+arr2);
        for(i=0;i<=a;i++){
           arr1.add(i);
            arr2.add(i);
            System.out.println("array1:"+arr1);
            System.out.println("array2:"+arr2);
        }
        for(i=0;i<=a;i++){
        if(i%2==0){
            arr3.add(i);
            System.out.println("List of even array elements:"+arr3);
        }
    else if(i%2 != 0){
        arr4.add(i);
            System.out.println("List of an odd elements:"+arr4);
        }
    else{
            System.out.println("end of the code:");
        }
        }
    }
}