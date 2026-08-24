package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class LargetRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        //base case
        if( heights == null || heights.length == 0 ) return 0;
        if( heights.length == 1 ) return heights[0];

        int maxArea = 0;

        int[] prevSmaller = new int[heights.length];

        Deque<Integer> st = new ArrayDeque<>();

        int n = heights.length;
        //precomputing the left boundary
        for( int i = 0 ; i < n ; i++ ){
            int current = heights[i];
            //finding the smaller
            while( !st.isEmpty() && current <= heights[ st.peek() ] ) {
                st.pop();
            }

            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push( i );
        }

        st.clear();

        //accessing every bar and assuming it will be the min bar for answer rectangle
        for( int i = n-1 ; i >= 0 ; i-- ){

            int current = heights[i];
            //the particular building can be tallest & can have max area


            //finding the left boundary
            while( !st.isEmpty() && current <= heights[ st.peek() ] ) {
                st.pop();
            }

            int rightBoundary = st.isEmpty() ? n : st.peek();

            int width  = rightBoundary - prevSmaller[i] - 1;

            maxArea = Math.max( maxArea, width * current );

            st.push(i);
        }


        return maxArea;
    }
}