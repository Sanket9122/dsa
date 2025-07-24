package hashing.situationalbased;
import java.util.*;

public class q2 {
    public HashMap<String,Integer> Question2(List<List<String>> votes) {
        HashMap<String, Integer> candidateVoteCounts = new HashMap<>();
        Map<String, Set<String>> candidateVoters = new HashMap<>();

        for (List<String> voteEntry : votes) {
            if (voteEntry.size() != 2) {
                continue;
            }
            String candidateId = voteEntry.get(0);
            String userId = voteEntry.get(1);

            Set<String> votersForCandidate = candidateVoters.computeIfAbsent(candidateId, k -> new HashSet<>());

            if (!votersForCandidate.contains(userId)) {
                votersForCandidate.add(userId);
                candidateVoteCounts.put(candidateId, candidateVoteCounts.getOrDefault(candidateId, 0) + 1);
            }
        }
        return candidateVoteCounts;
    }
    public static void main(String[] args) {
        q2 q = new q2();
        List<List<String>> votes = new ArrayList<>();
        votes.add(Arrays.asList("c1", "u1"));
        votes.add(Arrays.asList("c1", "u2"));
        votes.add(Arrays.asList("c1", "u1")); 
        votes.add(Arrays.asList("c2", "u3"));
        int result = q.Question2(votes).get("c1");
        System.out.println(result);
    }
}

// Algorithm Explanation:
// 1. We create a HashMap to count the votes for each candidate.
// 2. We create a HashMap to track the voters for each candidate.
// 3. We iterate over the input votes list.
// 4. For each vote entry, we check if it has exactly two elements (candidateId and userId).
// 5. We retrieve or create a Set of voters for the candidate using computeIfAbsent.
// 6. If the userId is not already in the Set of voters for that candidate, we add it.
// 7. We increment the vote count for the candidate in the candidateVoteCounts map.
// 8. Finally, we return the candidateVoteCounts map.

// 9. The main method demonstrates the usage of the Question2 method with a sample votes list.
// 10. The output will be the number of unique votes for candidate "c1", which is printed to the console.
// 11. The code handles cases where the vote entries may not have exactly two elements by checking the size of each entry.
// 12. The code uses a HashMap for efficient counting and a HashSet to ensure unique user IDs for each candidate.