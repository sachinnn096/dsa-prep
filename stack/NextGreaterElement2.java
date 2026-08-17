package stack;


import java.util.Deque;

class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {


        //it will store the answer
        int result[] = new int [nums.length];


        Deque<Integer> stack = new ArrayDeque<>();

        int n = nums.length;

        //hyptothetically doubling the array ---  for circular nextGreaterElement approach
        for( int end = 2*n-1 ; end >= 0; end-- ){

            int currentValue = nums[ end%n ];

            //finding the right side greater element -- next Greater Element
            while( !stack.isEmpty() && stack.peek()<=currentValue ){
                stack.pop();
            }

            if( end < n ){
                result[end] = stack.isEmpty() == true ? -1 : stack.peek();
            }

            //mandatory step
            stack.push( currentValue );

        }


        return result;
    }
}

//time n
//space n