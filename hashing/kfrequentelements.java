package hashing;
import java.util.*;
public class kfrequentelements {
    public int[] topkelements(int []nums ,int k){
        int n= nums.length;
        int [] result = new int[k];
        Map<Integer,Integer> resmap = new HashMap<>();
        for(int num : nums){
            resmap.put(num , resmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> resmap.get(a) - resmap.get(b));

        for(int key : resmap.keySet()){
            heap.add(key);
            if(heap.size() > k){
                heap.poll();
            }
        }

        for(int i = k-1; i >= 0; i--){
            result[i] = heap.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        kfrequentelements obj = new kfrequentelements();    
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        int [] result = obj.topkelements(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
///////algorithm explanation
// 1. Create a frequency map to count occurrences of each element.  
// 2. Use a min-heap to keep track of the top k frequent elements.
// 3. If the heap size exceeds k, remove the least frequent element.
// 4. Finally, extract the elements from the heap into an array and return it.
// This approach ensures that we efficiently find the k most frequent elements in the array.
