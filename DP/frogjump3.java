package DP;

public class frogjump3 {
    public int maxfrogjump(int [] stones){
        int n = stones.length;
        int max;  
        max = stones[1] - stones[0];

        for(int i=2; i<n ;i++){
            if(stones[i] - stones[i-2] > max){
                max = stones[i] - stones[i-2];
            }
        }
        if(stones[n-1] - stones[n-2] > max){
            max = stones[n-1] - stones[n-2];
        }
        return max;
    }
    public static void main(String[] args) {
        frogjump3 fj = new frogjump3();
        int[] stones = {0, 2, 5, 6,7};
        int result = fj.maxfrogjump(stones);
        System.out.println(result);
    }
}
