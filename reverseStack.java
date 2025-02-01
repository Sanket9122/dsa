import java.util.*;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Character> originalStack = new Stack<>();
        Stack<Character> reverseStack = new Stack<>();
    
        originalStack.push('(');
        originalStack.push(')');
        originalStack.push('[');
        originalStack.push(']');
      
        Stack<Character> tempStack = new Stack<>();
        for (Character ch : originalStack) {
            tempStack.push(ch);
        }
        
        while (!tempStack.isEmpty()) {
            reverseStack.push(tempStack.pop());
        }

        System.out.println("Original stack: " + originalStack);
        System.out.println("Reversed stack: " + reverseStack);
    }
}
