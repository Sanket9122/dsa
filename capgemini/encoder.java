package capgemini;
import java.util.*;

public class encoder {

    private boolean code(long n) {
        if (n < 0) {
            return false;
        }
        long s = (long) Math.sqrt(n);
        return (s * s == n);
    }

    private boolean msgdecoder(long n) {
        if (n < 0) {
            return false;
        }
        return code(5 * n * n + 4) || code(5 * n * n - 4);
    }

    public List<String> code(String[] msg) {
        List<String> fibonacciResults = new ArrayList<>();

        for (String message : msg) {
            StringBuilder encodedString = new StringBuilder();
            
            for (char c : message.toLowerCase().toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    int numCode = c - 'a' + 1;
                    encodedString.append(numCode);
                }
            }

            if (encodedString.length() > 0) {
                try {
                    long number = Long.parseLong(encodedString.toString());
                    if (msgdecoder(number)) {
                        fibonacciResults.add(encodedString.toString());
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Could not parse number from: " + encodedString);
                }
            }
        }
        return fibonacciResults;
    }

    public static void main(String[] args) {
        encoder obj = new encoder();
        String[] input = {"abd", "abc", "bce", "abcd"};
        
        List<String> output = obj.code(input);
        System.out.println("Input: " + java.util.Arrays.toString(input));
        System.out.println("Output: " + output);
    }
}