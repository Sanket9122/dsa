import java.util.*;
public class arrayimplementation {
    public static class Stack{
        int []arr=new int [10];
      private  int idx=0;
        void push(int x){
            arr[idx]=x;
            idx++;
        }
        int peek(){
            if (idx==0) {
                System.out.println("stack is empty");
                return -1;
            }
            return arr[idx-1];
        }
        int pop(){
            if (idx==0) {
                System.out.println("stack is empty");
                return -1;
            }
            int top = arr[idx-1];
           arr[idx-1]=0;
            idx--;
            return top;
        }
        void display(){
            for(int i=0;i<idx;i++){
                System.out.println(arr[i]);
            }
        }
        int size(){
            return idx;
        }
        boolean isEmpty(){
            if (idx==0) {
                return true;
            }
            return false;
        }
        boolean isFull(){
            if (idx==10) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }
        System.out.println("stack elements");
        st.display();
        System.out.println("stack size");
        System.out.println(st.size());
        System.out.println("stack top");
        System.out.println(st.peek());
    }
}
