import java.util.*;
public class LLimplementation {
   public static class Node{
       int data;
       Node next;
       Node(int data){
           this.data = data;
           this.next = null;
       }
   } 
   public static class LLstack{
      private Node head=null;
     private  int size=0;
       void push(int x){
           Node temp = new Node(x);
           temp.next=head;
           head=temp;
           size++;
       }
       void display(){
           Node temp = head;
           while(temp!=null){
               System.out.print(temp.data+" ");
               temp=temp.next;
           }
           System.out.println();
       }
       void pop(){
           if(head==null){
               System.out.println("stack is empty");
               return;
           }
           head=head.next;
           size--;
       }
       int size(){
           return size;
       }
       int peek(){
           if(head==null){
               System.out.println("stack is empty");
               return -1;
           }
           return head.data;
       }
       public static void main(String[] args) {
           LLstack st = new LLstack();
           Scanner sc = new Scanner(System.in);
           System.out.println("enter the number of elements");
           int n = sc.nextInt();
           System.out.println("enter the elements");
           for(int i=0;i<n;i++){
               st.push(sc.nextInt());
           }
           System.out.println("stack elements");
           st.display();
           System.out.println("stack size");
           System.out.println(st.size());
           System.out.println("stack top");
           System.out.println(st.peek());
           st.pop();
           st.display();
       }
    
}
}