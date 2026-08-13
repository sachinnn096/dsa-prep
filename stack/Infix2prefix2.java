package stack;



import java.util.*;
class Infix2prefix2 {
    static String infixToPrefix(String s) {
        // code here

        //+ab
        //is main operator aage rkhet h issliye ise peeche se travers krte h


        Deque<Character> operators = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();


        //reversing the array
        char arr[] = s.toCharArray();


        reverseTheArray( arr );
        //accessing from last
        // postfix banao ise

        for( char c:arr ){

            //if letter
            if( Character.isLetterOrDigit( c ) ) sb.append( c );

            else if( c == ')' ) operators.push( '(' );

            else if( c == '(' ) {

                while( operators.peek() != '(' )
                    sb.append( operators.pop() );

                if( !operators.isEmpty() )
                    operators.pop(); //removing the )
            }
            else{   // + - / * ^
                while( !operators.isEmpty() && priority( c ) < priority( operators.peek() )  ){

                    sb.append( operators.pop() );
                }
                //special case ^^ same ye right to left solve hota h ...issliye pop hoga firs ^ then left wala( ^ ) push hoga
                // in case ++ or ** etc toh push hoga kyuke inka associativity left to right hote h


                //yha empty bhi ho skta h stack
                if( c == '^' && !operators.isEmpty() &&  operators.peek() == '^' )
                    sb.append( operators.pop() );

                //push
                operators.push( c );

            }
        }

        //remaining part
        while( !operators.isEmpty() )
            sb.append( operators.pop() );

        return sb.reverse().toString();

    }
    private static int priority( char c ){

        if( c == '^') return 3;
        else if( c == '/' || c == '*' ) return 2;
        else if( c == '+' || c == '-' ) return 1;
        return -1;
    }

    private static void reverseTheArray( char []arr ){

        int i = 0;
        int j = arr.length-1;

        while( i<j ){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}






