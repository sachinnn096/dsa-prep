public class SearchInRotatedSortedArray {
}

/*
class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;

        // array is going to have one part sorted always either from left to mid or mid to right
        while( l <= r  ){

            int mid = l + ( r - l ) / 2 ; // preventing integer overflow cond  = [left+right]/2
            // checked for mid index
            if( nums[ mid ] == target ) return mid;
            // left part sorted [ works for single element also ]
            if( nums[l] <= nums[mid] ){

                if( target >= nums[l] && target < nums[mid] )  // why less than nums[mid] ??
                    r = mid-1;  // reducing the search spaace always, bcz target already compared with mid
                else
                    l = mid+1;  // reducing search space

            }else{  // right part is sorted
                if( target > nums[mid] && target <= nums[r] )
                    l = mid+1;
                else
                    r = mid-1;
            }
        }

        return -1;

    }
}

 */