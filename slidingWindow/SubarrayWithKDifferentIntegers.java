package slidingWindow;


import java.util.HashMap;
import java.util.Map;

class SubarrayWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {

        if( nums == null || nums.length  == 0 || k <= 0 || k > nums.length  ) return 0;

        return countSubarrays( nums, k ) - countSubarrays( nums, k-1 );
    }


    private int countSubarrays( int[] nums, int k ){

        //subarray cant be formed without any value
        if( k<=0 ) return 0;

        int left = 0;
        int count = 0;

        Map<Integer,Integer> uniqNumbers = new HashMap<>();

        //expanding the window
        for( int right = 0 ; right < nums.length ; right++ ){

            uniqNumbers.put( nums[right], uniqNumbers.getOrDefault( nums[right], 0 )+1 );

            //compfortZone out algorithm

            while( uniqNumbers.size() > k ){

                uniqNumbers.put( nums[left], uniqNumbers.get( nums[left] )-1 );
                if( uniqNumbers.get( nums[left] ) == 0 ) uniqNumbers.remove( nums[left] );
                left++;
            }


            count += right - left + 1;
        }
        return count;
    }
}