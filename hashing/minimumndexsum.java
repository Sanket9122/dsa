package hashing;
import java.util.*;
public class minimumndexsum {
    public HashMap<String,Integer> minIndexSum(String []list1 , String []list2){
        HashMap<String , Integer> map1 = new HashMap<>();
        HashMap<String , Integer> result = new HashMap<>();

        for(int i =0 ;i < list1.length; i++){;
            map1.put(list1[i], i);
        }   
        int minsum = Integer.MAX_VALUE;

        for(int j = 0  ;j<list2.length ; j++){
            String currrestaurant = list2[j];
            if(map1.containsKey(currrestaurant)){
                int indexsum = j + map1.get(currrestaurant);
                if(indexsum < minsum){
                    minsum = indexsum;
                    result.clear();
                    result.put(currrestaurant, indexsum);
                } else if(indexsum == minsum){
                    result.put(currrestaurant, indexsum);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        minimumndexsum obj = new minimumndexsum();
        String []list1 = {"KFC", "Burger King", "Pizza Hut", "Subway"};
        String []list2 = {"Pizza Hut", "KFC", "Subway", "Burger King"};
        HashMap<String, Integer> result = obj.minIndexSum(list1, list2);
        
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            System.out.println("Restaurant: " + entry.getKey() + ", Index Sum: " + entry.getValue());
        }
    }
}
