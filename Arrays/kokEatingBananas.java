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