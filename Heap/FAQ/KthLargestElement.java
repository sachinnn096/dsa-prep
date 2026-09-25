package Heap.FAQ;

//quick sort approach

import java.util.concurrent.ThreadLocalRandom;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {


        if( nums == null || k > nums.length || nums.length == 0  || k <= 0)
            return -1;
        return findKth( nums, 0, nums.length-1, k );

    }

    public int findKth( int[] nums, int start, int end, int k ){
        //implementing the quick sort idea
        int pivotInd = filterElements( nums,start,end,k );
        int rankInLargest = pivotInd-start+1;


        if( rankInLargest == k ) return nums[pivotInd];

        else if( k > rankInLargest ){

            k = k - rankInLargest;
            return findKth( nums, pivotInd+1, end, k );
        }
        else{
            return findKth( nums, start, pivotInd-1, k );
        }

    }

    //filter greater elements on front and lesser elements in back in array
    private int filterElements( int[] nums, int start, int end, int k ){

        // int randomIndex = (int)(Math.random() * ( end - start + 1 )) + start;
        int randomIndex = ThreadLocalRandom.current().nextInt(start, end + 1);

        //pivot ko bachane k liye use end main bhej rha hu
        swap( nums,end,randomIndex );

        int ind = start;

        //putting all greater elements in front
        for( int i = start ; i < end ; i++ ){

            if( nums[i] > nums[end] ){
                swap( nums,i,ind );
                ind++;
            }
        }
        //pivot value( end-index ) use uske sahi jagah pr laate hue
        swap( nums,ind,end );

        return ind;
    }

    public void swap( int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}