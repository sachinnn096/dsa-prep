package stack;


import java.util.ArrayList;
import java.util.Deque;

class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here


        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for( int i = arr.length-1;i>=0;i-- ){

            //finding the next greater element in stack

            while( !stack.isEmpty() && arr[i] >= stack.peek()  ){
                stack.pop();
            }

            if( stack.isEmpty() ) {
                res.add( -1 );
            }else{
                res.add( stack.peek() );
            }

            //push the current element into stack
            stack.push( arr[i] );


        }

        reverseTheList( res );
        return res;
    }
    private void reverseTheList( ArrayList<Integer> res ){

        int i = 0;
        int j = res.size()-1;

        while( i<=j ){
            int temp = res.get( i );
            res.set( i,res.get(j) );
            res.set( j,temp );
            i++;j--;
        }

    }
}