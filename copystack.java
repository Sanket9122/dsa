import java.util.*;

public class copystack {
    public static void main(String[] args) {
        Stack<Character> originalStack = new Stack<>();
        Stack<Character> copyStack = new Stack<>();
   
        originalStack.push('(');
        originalStack.push(')');
        originalStack.push('[');
        originalStack.push(']');
        
        for (Character ch : originalStack) {
            copyStack.push(ch);
        }

        System.out.println("Original stack: " + originalStack);
        System.out.println("Copied stack: " + copyStack);
    }
}
