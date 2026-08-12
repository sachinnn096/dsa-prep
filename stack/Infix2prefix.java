package stack;


class Infix2prefix {
    static String infixToPrefix(String s) {


        // code here

        //algo
        //iterate through the string
        // if c is character , letter or digit  main.push( c );
        // else ye operator h
        // (  directly push
        // ^ toh bhi dirclty push -- kyu-> because  ye right to  left solve hota h ... ^^^ means inhe ek dusre k upar push kiya jaa skta h & ise ur sabhi ke upar bhi push kiya jaa skta h
        //) remove untill (  and solve eqn and push to operand & then finally remove (
        // * + -  -> ab in main se koi ek aata h toh aap use tab tk push ni kr skte jab tak operator stack ka peek ka priority iske equal ya jyda h

        //   +*  kyuke + se phale * solve hoga toh(Bodmas) ....* push kiya jaa skta h
        // *+ lekin yha * ke prioriyt jyda h toh phale vo solve hoga then + push krenge



        //code
        //store +-*()
        Deque<Character> operators = new ArrayDeque<>();
        //store a b c d
        Deque<String> operands  = new ArrayDeque<>();



        for( char c : s.toCharArray() ){

            //if character
            if( Character.isLetterOrDigit( c ) ) operands.push( c+"");
            else if( c == '(' || c == '^' ) operators.push( c );
            else if( c == ')' ){   //solve the complete bracket first

                while( operators.peek()!= '(' ){

                    String l = operands.pop();
                    String sl = operands.pop();
                    operands.push( operators.pop()+sl+l );
                }
                operators.pop(); //removing the (

            }
            else{
                while( !operators.isEmpty() &&  priority( operators.peek() ) >= priority( c )  ){
                    String l = operands.pop();
                    String sl = operands.pop();
                    operands.push( operators.pop()+sl+l );
                }
                operators.push( c );
            }
        }

        //abhi bhi stack operators wala empty ni hua

        while( !operators.isEmpty() ){
            String l = operands.pop();
            String sl = operands.pop();
            operands.push( operators.pop()+sl+l );
        }

        if( operands.isEmpty() ) throw new IllegalStateException();
        return operands.pop();
    }

    private static int priority( char c ){
        if( c == '^' ) return 3;
        else if( c == '*' || c == '/' ) return 2;
        else if( c == '+' || c == '-' ) return 1;
        else return -1; //   (
    }

}
