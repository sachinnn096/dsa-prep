package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {

        //base case
        if( num == null || num.length() == k  ) return "0";
        if( k == 0  ) return num;

        if( k > num.length() ){
            throw new IllegalArgumentException("value of k is: invalid");
        }

        //logic
        // traverse the digits from left to right
        // we will main the increasing monotonic stack

        Deque<Character> st = new ArrayDeque<>();

        for( int i = 0; i < num.length() ; i++ ){
            //getting current character
            char curr = num.charAt(i);

            //case st.peek() = 5 and curr = 3 ... maintaining the increasing monotonic stack
            while( !st.isEmpty() && curr < st.peek() && k > 0 ){
                st.pop();
                k--;
            }
            st.push( curr );
        }

        //if k is remaining
        while( k>0 ){
            st.pop();
            k--;
        }

        StringBuilder min = new StringBuilder();
        //cleaning input

        while( !st.isEmpty() ){
            //getting last element from stack
            char temp = st.pollLast();
            //not allowing to push leading zeroes
            if(min.length() == 0 && temp == '0' ) continue;
            else min.append( temp );

        }
        // 0000 all cleaned ...min is empty
        //cleaning zeroes from lead
        return min.length()!=0? min.toString():"0";

    }
}


//hint 1 try to build the number in increasing order ... because it will be the minimum number that can be build with those digits