package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class TrappingRainWater1 {
    public int trap(int[] height) {



        int n = height.length;
        //base case
        if( n<=2 ) return 0;

        int waterStored = 0;


        Deque<Integer> stack = new ArrayDeque<>();

        //traversing each buildings
        for( int i = 0 ; i < n ; i++ ){

            if( stack.isEmpty() || height[stack.peek()] >= height[i] ){
                stack.push( i );
            }else{

                //accessing the building that will hold water

                while( !stack.isEmpty() && height[i] > height[stack.peek()] ){

                    //building that will store the water
                    int waterBuilding = height[stack.pop()];
                    //means it does not have left boundary
                    if( stack.isEmpty() ) break;
                    //width of rectangle
                    int width = i - stack.peek() - 1;

                    int water = Math.min( height[stack.peek()] , height[i] ) - waterBuilding;
                    waterStored += water*width;


                }

                stack.push( i );

            }


        }

        return waterStored;

    }
}

//time complexity  n
//space complexity n