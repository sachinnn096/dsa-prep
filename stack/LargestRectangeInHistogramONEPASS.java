package stack;

import java.util.ArrayDeque;
import java.util.Deque;

class LargestRectangeInHistogramONEPASS {
    public int largestRectangleArea(int[] heights) {

        // to find rectangle with max height ....assume every bar as min then find how much it can extend in right & left to provide the max area
        // (x-2)...(x+2)(x+1)...x...(x+1)(x+2)x....x-1

        //approach
        //when you enconter a element less than previous element means it can be the right boundary for left side element

        if( heights == null || heights.length == 0 ) return 0;
        if( heights.length == 1 ) return heights[0];

        Deque<Integer> st = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;

        for( int i = 0 ; i <= n ; i++ ){
            //getting current bar
            int current = i == n ? 0 : heights[i];

            //if it is less than bar in that lies in stack means it can be right boundary

            while( !st.isEmpty() && current <= heights[st.peek()]  ){

                int minBar = heights[st.pop()];
                int leftBoundary = st.isEmpty() ? -1 : st.peek() ;
                int width = i - leftBoundary - 1;

                maxArea = Math.max( maxArea , width*minBar );
            }
            //pushing current bar ...because it can be the taller than upcoming bar ...which can be right boundary for this
            st.push(i);
        }

        return maxArea;
    }
}

