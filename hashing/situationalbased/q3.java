package hashing.situationalbased;
import java.util.*;

public class q3 {

    public List<String> getMostDiverseReviewers(List<List<String>> reviews, int N) {
        if (reviews == null || reviews.isEmpty() || N <= 0) {
            return new ArrayList<>();
        }

        Map<String, Set<String>> reviewerProducts = new HashMap<>();

        for (List<String> reviewEntry : reviews) {
            if (reviewEntry.size() != 2) {
                continue;
            }
            String productId = reviewEntry.get(0);
            String reviewerId = reviewEntry.get(1);

            reviewerProducts.computeIfAbsent(reviewerId, k -> new HashSet<>()).add(productId);
        }

        List<Map.Entry<String, Integer>> diversityList = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : reviewerProducts.entrySet()) {
            String reviewerId = entry.getKey();
            int diversityCount = entry.getValue().size();
            diversityList.add(new AbstractMap.SimpleEntry<>(reviewerId, diversityCount));
        }

        Collections.sort(diversityList, (entry1, entry2) -> {
            int diversityCompare = Integer.compare(entry2.getValue(), entry1.getValue());
            if (diversityCompare != 0) {
                return diversityCompare;
            }
            return entry1.getKey().compareTo(entry2.getKey());
        });

        List<String> topNReviewers = new ArrayList<>();
        for (int i = 0; i < N && i < diversityList.size(); i++) {
            topNReviewers.add(diversityList.get(i).getKey());
        }

        return topNReviewers;
    }
    public static void main(String[] args) {
        q3 q = new q3();
        List<List<String>> reviews = new ArrayList<>();
        reviews.add(Arrays.asList("p1", "r1"));
        reviews.add(Arrays.asList("p2", "r1"));
        reviews.add(Arrays.asList("p1", "r2"));
        reviews.add(Arrays.asList("p3", "r2"));
        reviews.add(Arrays.asList("p4", "r3"));
        reviews.add(Arrays.asList("p5", "r3"));
        reviews.add(Arrays.asList("p6", "r4"));

        List<String> result = q.getMostDiverseReviewers(reviews, 2);
        System.out.println(result); 
    }
}

//algorithm explanation :
//1. We first check if the input list of reviews is null or empty, or if N is less than or equal to 0, returning an empty list in such cases.
//2. We create a map to track the products reviewed by each reviewer.
//3. For each review entry, we extract the product ID and reviewer ID.
//4. If the review entry has a size of 2 (product ID and reviewer ID), we add the product ID to the set of products reviewed by the reviewer.
//5. We create a list to store the diversity count for each reviewer.
//6. We iterate over the map of reviewer products and calculate the diversity count for each reviewer.
//7. We sort the diversity list in descending order of diversity count and then alphabetically by reviewer ID.
//8. We extract the top N reviewers with the highest diversity count and return their IDs as a list.
//9. In the main method, we create a sample list of reviews and call the method to get the most diverse reviewers, printing the result.
//10. The output will show the top N reviewers based on the number of unique products they have reviewed.
//11. The algorithm efficiently uses a HashMap and a HashSet to ensure that we count unique products for each reviewer and sort them based on their diversity count.