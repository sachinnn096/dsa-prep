package stack.linklistImp;


import java.util.ArrayDeque;
import java.util.Deque;

class MinStackOptimized {

    // it will store the values
    private Deque<Long> stack;

    private long min;

    //assiging the implementation

    public MinStackOptimized() {
        stack = new ArrayDeque<>();
    }

    //pushing the value
    public void push(int value) {

        //case 1 stack empty
        if( stack.isEmpty() ){
            stack.push( (long)value );
            min = value;
        }
        //case 2 value greater than minimum
        else if( value >= min ) stack.push( (long)value );
            //case 2 found new minimum
        else{
            //ab mathematical realtion bna rhe h ke 2*value-min
            //taake stack main  <min se stored value flag de rhe h ...k iss value ko pop krke aapko last minimum restore krna h

            long temp = 2L*value - min;     //( min>value ->     value + value - min = value - ( negative value ) ) = < value
            stack.push( temp );
            min = value;
        }

    }

    public void pop() {

        long poppedValue = stack.pop();
        if( poppedValue < min )  //time aagya new minimum restore krne ka jo ise bade hoge
            min  = (2L*min - poppedValue);

    }

    public int top() {
        long val = stack.peek();
        if( val>=min ) return (int)val;
        else return (int)min;

        //in case chote value h vo bhi min se --- flag
        // return (int)(2*min-val);
    }

    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
