package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if( nums == null || nums.length == 0 || k > nums.length )
            throw new IllegalArgumentException("invalid length");
        int n = nums.length;

        int ind = 0;

        //array
        int[] answerWindow = new int [n-k+1];

        //monotonic decreaing q
        Deque<Integer> q = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ){

            int current = nums[i];

            //maintaining a monotonic decreasing q
            //we are poping the equal elements also to save memory in case 10 million 2 elements
            while( !q.isEmpty() &&  current >= nums[q.peekLast()] ){
                q.removeLast();
            }
            //pushing from back
            q.addLast( i );
            //maintaing the window ...removing elements does not belong to current window
            if( q.peekFirst() <= i-k )
                q.removeFirst();

            if( i >= k-1 )
                answerWindow[ind++] = nums[q.peekFirst()];

        }
        return answerWindow;
    }
}

//time complexity n
//space complexity k+1
