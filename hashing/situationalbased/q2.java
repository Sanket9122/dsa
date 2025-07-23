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