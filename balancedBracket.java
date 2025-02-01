import java.util.*;
public class balancedBracket
{
    public static void main(String[] args) {
        String exp = "({[]})";
        System.out.println(isBalanced(exp));
    }
    public static boolean isBalanced(String exp) {
        Stack<Character> st = new Stack<>();
      for(int i = 0; i < exp.length(); i++){
       char ch = exp.charAt(i);
          if(st.isEmpty()){
                st.push(ch);
            }
       else if((ch==')' && st.peek() == '(')||(ch=='}' && st.peek() == '{')||(ch==']' && st.peek() == '[')){
                st.pop();
            }
            else{
                st.push(ch);
            }      
        }
 return (st.isEmpty());
    }
}