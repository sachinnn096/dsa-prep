package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class ValidParenthesis {
    public boolean isBalanced(String s) {
        // code here

        if( s.length()%2 == 1 ) return false;

        Deque<Character> d = new ArrayDeque<>();

        for( char c:s.toCharArray() ){
            if( c == '(' || c == '{' || c =='[' )
                d.push( c );
            else{
                if( d.isEmpty() ) return false;

                if(
                        c ==']' && d.peek()!='['       ||
                                c == '}' && d.peek() != '{'    ||
                                c == ')' && d.peek()!='('
                ) return false;

                d.pop();
            }
        }
        return d.isEmpty();

    }
}