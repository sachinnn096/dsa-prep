package slidingWindow;


import java.util.HashMap;
import java.util.Map;

class Leetcode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {


        int count = 0;      //store the no of subarrays with sum goal
        int sum = 0;
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put( 0,1 );


        for( int i = 0 ; i < nums.length ; i++ ){
            sum+=nums[i];

            count += prefix.getOrDefault( sum - goal, 0 );
            prefix.put( sum, prefix.getOrDefault( sum,0 )+1 );

        }
        return count;

    }
}