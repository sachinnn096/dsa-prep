package stack.linklistImp;

import java.util.Deque;

//class MinStack {
//
//    Deque<Pair> stack;
//
//
//
//    //helper class
//    private class Pair{
//        protected int value;
//        protected int minimumValue;
//
//        public Pair( int x,int y ){
//            this.value = x;
//            this.minimumValue = y;
//        }
//    }
//
//
//    public MinStack() {
//        stack = new ArrayDeque<>();
//    }
//
//    public void push(int value) {
//
//        //case1 empty
//        if( stack.isEmpty() ){
//            stack.push( new Pair( value,value ) );
//            return;
//        }
//
//
//        //case2 non empty
//        int uptonowMinValue = Math.min( value, stack.peek().minimumValue );
//
//        stack.push( new Pair( value,uptonowMinValue ) );
//
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek().value;
//    }
//
//    public int getMin() {
//
//        return stack.peek().minimumValue;
//
//    }
//}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */





class MinStack {

    private Deque<Integer> stack;
    private int minvalue;




    public MinStack() {
        stack = new ArrayDeque<>();
    }


    public void push(int value) {

        //case 1 empty
        if( stack.isEmpty() ){
            stack.push( value );
            minvalue = value;
            return;
        }
        //case 2
        //naye lowest value mil gye h...aisa value store kro jo
        else if( value < minvalue ){
            //naye chote value mil gye h ...kuch aisa store kro jo last min value ko nikalne main help kr paaye


            int temp = value*2 - minvalue;
            minvalue = temp;
            stack.push(  minvalue );
        }
        //case 3
        else stack.push( value );

    }

    public void pop() {
        //agr current stack wale value and minstack vale same h toh pop kro

        int poppedValue = stack.pop();

        if( poppedValue < minvalue ){
            minvalue = 2*minvalue - poppedValue;

        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minvalue;
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