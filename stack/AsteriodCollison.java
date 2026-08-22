package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class AsteriodCollison {
    public int[] asteroidCollision(int[] asteroids) {

        //stack for collision
        Deque<Integer> stack = new ArrayDeque<>();

        for( int current:asteroids ){

            //if the asteriod direction is left means -ve ...collision possibility is there
            if( current < 0  ){

                //this asteriod explode all right moving asteriods with value less than itself
                while( !stack.isEmpty() && stack.peek() > 0 && Math.abs( stack.peek() ) < Math.abs( current ) ){
                    stack.pop();
                }

                //either stack empty or asteriods with same direction
                if( stack.isEmpty() || stack.peek() < 0  ){
                    stack.push( current );
                }
                //asteriod with same size & opposite direction will explode each other
                else if( Math.abs( stack.peek() ) == Math.abs( current ) ) stack.pop();
                    // right moving asteriod size is bigger and other onw will explode
                else {

                }

            }else{
                //means asteriod in right direction - positive
                stack.push( current );
            }

        }

        int newSize = stack.size();
        //wil store the answer
        int result[] = new int [newSize];

        int ptr = newSize-1;

        while( !stack.isEmpty() ){
            result[ ptr-- ] = stack.pop();
        }
        return result;
    }
}