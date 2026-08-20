package stack;

class TrappingRainWater2 {
    public int trap(int[] height) {

        //algorithm -- khud se ke h
        //two pointer algorithm
        // leftmax and rightmax intialized 2 variables
        //left and right intialized 2 pointers
        // while left < right runs
        // if got new height[left] > leftmax .... update leftmax
        //similiary if height[right] > rightmax ....update rightmax

        // if left pointer value smaller find water and move
        //else if right pointer smaller move that




        int n = height.length;
        //base case
        if( n<=2 ) return 0;

        int waterStored = 0;

        int left = 0;
        int right = n-1;

        int leftmax = 0;
        int rightmax = 0;

        while( left < right ){
            //if got a new left max
            if( height[left] > leftmax ) leftmax = height[left];

            if( height[right] > rightmax ) rightmax = height[right];

            //if right pointer height is smaller ...definately it
            if( leftmax < rightmax ){

                int water = leftmax - height[left];
                waterStored += water;
                left++;
            }
            else {
                int water = rightmax - height[right];
                waterStored += water;
                right--;
            }

        }
        return waterStored;

    }
}
