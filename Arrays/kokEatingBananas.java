import java.util.*;
public class kokEatingBananas{
    public int EatBananas(int [] piles  , int hours){
        int maxpilesize =0;
        for(int pile :piles ){
            maxpilesize =Math.max(maxpilesize , pile);
        }

        long low = 1;
        long high = maxpilesize;
        long ans = maxpilesize;
        while (low <= high ){
            long mid  = low +(high - low )/2;
            long hoursneeded =0 ;
            for(int pile :piles){
                hoursneeded += (pile + mid -1) /mid ;
            }
            if (hoursneeded <= hours){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        kokEatingBananas obj = new kokEatingBananas();
        int [] piles = {3,6,7,11};
        int [] piles1 = {30,11,23,4,20};
        int [] piles2 = {30,11,23,4,20,5};
        System.out.println(obj.EatBananas(piles , 8)); 
        System.out.println(obj.EatBananas(piles1 , 5)); 
        System.out.println(obj.EatBananas(piles2 , 7)); 
    }
}

//algorithm explanation :
// 1. Find the maximum size of the pile.
// 2. Use binary search to find the minimum eating speed (k) such that Koko can finish eating all bananas in the given hours.
// 3. For each mid value in the binary search, calculate the total hours needed to eat all bananas at that speed.
// 4. If the total hours needed is less than or equal to the given hours, update the answer (k) to the current mid value.
// 5. Otherwise, continue the binary search in the left half of the search range.   
// 6. Return the minimum eating speed (k) found.

//example visualization:
// piles = [3,6,7,11], hours = 8
// maxpilesize = 11
// low = 1, high = 11, ans = 11
// mid = 6
// hoursneeded = (3 + 6 - 1) / 6 = 2    
// hoursneeded = (6 + 6 - 1) / 6 = 2
// hoursneeded = (7 + 6 - 1) / 6 = 2
// hoursneeded = (11 + 6 - 1) / 6 = 2
// total hoursneeded = 2 + 2 + 2 + 2 = 8
// Since total hoursneeded <= 8, update ans = 6, high = 5
// Repeat the process until low > high
// Final answer is 6, which is the minimum eating speed at which Koko can finish eating all bananas in 8 hours.
