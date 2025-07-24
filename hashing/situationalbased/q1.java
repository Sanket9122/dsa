package hashing.situationalbased;

import java.util.*;  
public class q1{
    public List<String>findsuspicious(List<List<String>> logs , int thrshold){
        Map<String,Integer>map  = new HashMap<>();
        for(List<String> logentry : logs){
            String user_id = logentry.get(0);
            String action = logentry.get(1);

            if(logentry.size() != 2){
                continue ; 
            }
            if(action.equals("login")){
                map.put(user_id, map.getOrDefault(user_id, 0) + 1);
            }
        }
        Set<String> suspiciousUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > thrshold) {
                suspiciousUsers.add(entry.getKey());
            }
        }
        List<String> result = new ArrayList<>(suspiciousUsers);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        q1 obj = new q1();
        List<List<String>> logs = new ArrayList<>(); 
        logs.add(Arrays.asList("user1", "login")); 
        logs.add(Arrays.asList("user2", "login")); 
        logs.add(Arrays.asList("user2", "logout")); 
        logs.add(Arrays.asList("user3", "login")); 
        logs.add(Arrays.asList("user3", "login")); 
        logs.add(Arrays.asList("user3", "logout")); 
        logs.add(Arrays.asList("user1", "logout"));
        System.out.println(obj.findsuspicious(logs , 1));
    }
}

//algorithm explanation :
//1. We create a map to count the number of login actions for each user.
//2. We iterate over the log entries and update the map accordingly.
//3. We create a set to store the suspicious users.
//4. We iterate over the map and add users with a login count greater than the threshold to the set.    
//5. Finally, we convert the set to a list, sort it, and return it.
//6. The main method demonstrates the usage of the findsuspicious method with a sample log list.
//7. The output will be a sorted list of user IDs that have logged in more than the specified threshold number of times.
//8. The output will show the suspicious users based on the login threshold.
//9. The code handles cases where the log entries may not have exactly two elements by checking the size of each entry.
//10. The code uses a HashMap for efficient counting and a HashSet to ensure unique user IDs in the result.