package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class PostFix2Infix {
    static String postToInfix(String exp) {
        // code here
        //operand1 operand2 operator ab+

        //iterate the char array from start
        // if character push into stack
        //else( operator )
        //pop operand2 from stack,
        //then operand 1 from stack
        //then make the combined eqn & push into stack
        //combined eqn = operand1 + operator + operand2

        //edge case 1


        //improvement 2
        if( exp == null || exp.isEmpty() ) return exp;

        Deque<String> stack = new ArrayDeque<>();

        for( int i = 0;i<exp.length();i++ ){

            char c = exp.charAt(i);

            //charcter
            if( Character.isLetterOrDigit( c )  )

                // stack.push( c+"" );   //improvement 1
                stack.push( String.valueOf( c ) ); //converting char to string
            else{
                //operator

                if( stack.size()<2 )
                    throw new IllegalArgumentException( "invalid expression: Insufficient elements in stack" );

                String operand2 = stack.pop();
                String operand1 = stack.pop();

                StringBuilder combined = new StringBuilder()
                        .append("(")
                        .append(operand1)
                        .append( c ) //operator
                        .append( operand2 )
                        .append(")");

                stack.push( combined.toString() );

            }
        }

        if( stack.size()!=1 )
            throw new IllegalArgumentException( "invalid expression" );

        //return result expression
        return stack.pop();

    }
}



//improvement 3
// for( char c:exp.toCharArray() ){
