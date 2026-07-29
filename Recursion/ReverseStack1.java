package Recursion;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class ReverseStack1
{
    public static void reverseStack(Stack<Integer> st) {


        // code here
        //fist remove all the element from stack recursively

        //now push the each element at the very bottom of the stack


        Queue<Integer> q = new ArrayDeque<>();
        recursivepop( st,q );




    }


    public static void recursivepop( Stack <Integer> st,Queue<Integer> q ){

        if( st.isEmpty() ) return;


        int topElement = st.pop();
        //recursive call
        q.add( topElement );

        recursivepop( st , q );

        //now pushing into the stack again in reverse order

        st.push( q.remove() );

    }


}
