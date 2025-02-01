package hashing;
import java.util.*;

class GFG {


static boolean checkIsAP(int arr[], int n) {
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	int smallest = Integer.MAX_VALUE, second_smallest = Integer.MAX_VALUE;
	for (int i = 0; i < n; i++) {

	
	if (arr[i] < smallest) {
		second_smallest = smallest;
		smallest = arr[i];
	}

	else if (arr[i] != smallest
			&& arr[i] < second_smallest){
		second_smallest = arr[i];
            }

	if (!hm.containsKey(arr[i])) {
		hm.put(arr[i], 1);
	}

	else
		return false;
	}

	int diff = second_smallest - smallest;
	for (int i = 0; i < n - 1; i++) {
	if (!hm.containsKey(second_smallest))
		return false;
	second_smallest += diff;
	}
	return true;
}

public static void main(String args[]) {
	int arr[] = { 20, 25, 5, 0, 10 };
	int n = arr.length;

	if (checkIsAP(arr, n)) {
	System.out.println("Yes");
	} else {
	System.out.println("No");
	}
	;

}
}

// This code is contributed by gfgking
