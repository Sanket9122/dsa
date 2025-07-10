package hashing;
import java.util.*;
public class HappyNumber {
    public boolean isHappy(int num){
        int res = 0;
        HashSet<Integer> resultset = new HashSet<Integer>();
        while (num != 1 && !resultset.contains(num)) {
            resultset.add(num);
            res = 0;
            while (num > 0) {
                int digit = num % 10;
                res += digit * digit;
                num /= 10;
            }
            num = res;
        }
        return num == 1;
    }
    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        int num = 19;
        System.out.println(obj.isHappy(num));
    }
}
