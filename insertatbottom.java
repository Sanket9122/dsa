import java.util.*;
public class insertatbottom{
  public static void insertAtBottom (Stack <Integer>stack ,int item){
    if(stack.isEmpty()){
      stack.push(item);
    }
    else{
      int i = stack.pop();
      insertAtBottom(stack,item);
      stack.push(i);
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack <Integer>stack = new Stack <Integer>();
    System.out.println("Enter the number of elements");
    int n = sc.nextInt();
    System.out.println("Enter the elements");
    for(int i=0;i<n;i++){
      stack.push(sc.nextInt());
    }
    System.out.println("Enter the element to be inserted at bottom");
    int item = sc.nextInt();
    insertAtBottom(stack,item);
    System.out.println(stack);
  }
}