package slidingWindow;

// try to find maximum window with count of zeroe < or equal to k
//because if you are not allowed to flip more than k zeroes in order to find out the maximum consecutives ones

class MaxConsecutive3 {
    public int longestOnes(int[] nums, int k) {


        if( nums == null ) return 0;
        if( k >= nums.length ) return nums.length;


        int maxLen = 0;
        int n = nums.length;
        int cz = 0;
        int left = 0;

        //expanding subarray in right side
        for( int right = 0 ; right < n ; right++ ){

            //counting zeros
            if( nums[right] == 0 ) cz++;

            //shrinking subarray from left if count of zeroes is more than k
            while( left <= right && cz > k ){
                if( nums[left] == 0 ) cz--;
                left++;
            }

            //updating length of subarray
            maxLen = Math.max( maxLen, right-left+1 );

        }

        return maxLen;
    }
}