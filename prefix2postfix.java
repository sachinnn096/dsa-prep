import java.util.ArrayDeque;
import java.util.Deque;

class prefix2postfix {



    static Deque<String> stack;


    static String preToPost(String s) {
        // code here

        stack = new ArrayDeque<>();

        String postfix = prefix2postfix( s );

        return postfix;
    }


    public static String prefix2postfix( String infix ){

        //acessing from last bcz we want to visit operand first
        for( int i = infix.length()-1 ; i >= 0 ; i-- ){

            char c = infix.charAt( i );

            //character is operand
            if( Character.isLetterOrDigit( c ) ){
                stack.push( String.valueOf( c ) );


            }else{
                solveForOperator( c );
            }

        }

        return stack.pop();
    }


    public static void solveForOperator( char operator ){

        String leftOp = stack.pop();
        String rightOp = stack.pop();

        StringBuilder combined = new StringBuilder();
        combined.append( leftOp).append( rightOp ).append( operator );

        stack.push( combined.toString() );

    }

}