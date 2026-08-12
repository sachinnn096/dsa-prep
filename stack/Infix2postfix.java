package stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Infix2postfix {


    private final static Map<Character,Integer> priority = new HashMap<>();

    static{
        priority.put( '^',3 );
        priority.put( '/',2 );
        priority.put( '*',2 );
        priority.put( '+',1 );
        priority.put( '-', 1 );
        priority.put( '(', 0 );

    }


    public static String infixToPostfix(String s) {

        // store the priority





        //sequence maintain kregea
        Deque<Character> stack = new ArrayDeque<>();

        //ans store krege
        StringBuilder sb = new StringBuilder();

        // code here
        for( char c :s.toCharArray() ){

            //case 1 either letter or digit
            if( Character.isLetterOrDigit( c ) ) sb.append( c );
                //case 2 operators        ( ) ^ */ +-

            else if( c == '(' ) stack.push( c );
            else if( c == ')' ) {
                while( stack.peek()!='(' ) sb.append( stack.pop() );
                //removing (
                stack.pop();
            }else if( c == '^' ) stack.push(c);
            else {
                while( !stack.isEmpty() && priority.get( stack.peek() ) >= priority.get( c ) )
                    sb.append( stack.pop() );

                stack.push( c );
                //ab stack main koi more precedence wala ni h current char se
                // * mere priority jyda phale main excute honga +,-
                //  / mere ur * ke priority same h & i came first so i will execute first
                // ^ mere priority sabse jyda h and hamesha phale execute hunga ( +,-,*,/ )
                //   special case  ^ ^ abhi second wala phale execute hoga ...ur aisa krne k liye hame first(^) iske upar second( ^ ) ko push krenge
                //  ^ ^ ab pop kroge toh phale second then first bhar nikal kr aayega ( right -> left associativity)
                //iske alava sab ke associativity left to right hote h
            }



        }


        while( !stack.isEmpty() ) sb.append( stack.pop() );

        return sb.toString();

    }


}