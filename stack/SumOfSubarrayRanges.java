package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {

        //
        long res = 0;
        int n = nums.length;

        long minSum[] = new long[n];
        long maxSum[] = new long[n];

        //monotonic stack
        Deque<Integer> st = new ArrayDeque<>();
        //       bigger...arr[i]...bigger

//find min of every subarray with ending index i
        for( int i = 0 ; i < n ; i++  ){
            long current = (long)nums[i];
//REMOVING ELEMENTS UNTILL WE FOUND THE NEW SMALLER                          (X-1)...(X)(X+2)(X+1)...X
            while( !st.isEmpty() && current <= nums[st.peek()] ) st.pop();
//sum of minimum of all subarray ending with index i

//means in left side of array ...every values is greater
            if( st.isEmpty() ){
                minSum[i] = ( i + 1 ) * current;
            }else{
                minSum[i] = ( i - st.peek() ) * current;
                minSum[i] += minSum[st.peek()];
            }
            st.push( i );
        }

        st.clear();


//finding the sum of maximum element of each subarray ending with index i
        for( int i = 0 ; i < n ; i++ ){
            long current = (long)nums[i];

//REMOVING ALL SMALLER/EQUAL VALUES TO FIND GREATER                            (X+1)....(X)(X-2)(X-1)...X
            while( !st.isEmpty() && current >= nums[st.peek()] )  st.pop();

//MEANS ALL LEFT VALUES WERE SMALLER THAN CURRENT
            if( st.isEmpty()  ){
                maxSum[i] = ( i + 1 ) * current;
            }else{
                maxSum[i] = ( i - st.peek() ) * current;
                maxSum[i] += maxSum[st.peek()];
            }

            st.push( i );
        }

        for( int i = 0 ; i < n ; i++ ){
            res += maxSum[i] - minSum[i];
        }

        return res;
    }
}

//hint 1 for every index of subarray...find min of every subArray ending with index i;
//   similiarly for every index of subarray...find the maximum of every subarray with index i;
// return  sigma max - sigma min