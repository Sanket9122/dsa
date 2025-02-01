import java.util.*;
public class removefrombottom {
    public static int removeFromBottom(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int bottom = tempStack.pop();
 
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return bottom;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++) {
            stack.push(sc.nextInt());
        }
        System.out.println("Enter the element to be removed from bottom");
        removeFromBottom(stack);
        System.out.println(stack);
    }
}
