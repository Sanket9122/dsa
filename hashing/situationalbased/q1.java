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