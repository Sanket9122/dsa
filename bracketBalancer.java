public class bracketBalancer {
    public static void main(String[] args) {
        String brackets = "(()))(";
        System.out.println("Number of removable brackets: " + removableBrackets(brackets));
    }

    public static int removableBrackets(String brackets) {
        int open = 0;  
        int close = 0;  
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                open++;
            } else if (bracket == ')') {
                if (open > 0) {
                    open--;  
                } else {
                    close++; 
                }
            }
        }
     return open + close;
    }
}
