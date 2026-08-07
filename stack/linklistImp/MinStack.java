package stack.linklistImp;

import java.util.Deque;

class MinStack {

    Deque<Pair> stack;



    //helper class
    private class Pair{
        protected int value;
        protected int minimumValue;

        public Pair( int x,int y ){
            this.value = x;
            this.minimumValue = y;
        }
    }


    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int value) {

        //case1 empty
        if( stack.isEmpty() ){
            stack.push( new Pair( value,value ) );
            return;
        }


        //case2 non empty
        int uptonowMinValue = Math.min( value, stack.peek().minimumValue );

        stack.push( new Pair( value,uptonowMinValue ) );

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {

        return stack.peek().minimumValue;

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