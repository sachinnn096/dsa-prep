package stack;


import java.util.ArrayDeque;
import java.util.Deque;

class Prefix2infix {
    static String preToInfix(String s) {
        // code here

        if( s == "" || s == null ) return s;

        //if s is null or empty then

        char arr[] = s.toCharArray();
        Deque<String> infix = new ArrayDeque<>();



        for( int i = arr.length-1;i>=0;i-- ){

            //getting current character
            char c = arr[i];

            if( Character.isLetterOrDigit( c ) )
                infix.push( c+"");

            else{ //means it is a operator

                if( infix.size()<2 )
                    throw new IllegalArgumentException("invalid");

                String leftOperand = infix.pop();
                String rightOperand = infix.pop();

                String combined =  "("+leftOperand+c+rightOperand+")";
                infix.push( combined );
            }


        }

        if( infix.size()!=1 ) throw new IllegalArgumentException( "prefix expression not valid" );

        return infix.pop();

    }
}

/*

1. High-Level Approach Batao (The "Why")
Sabse pehle direct code line-by-line padhne ke bajaye, unhe core logic batao.

"Sir/Ma'am, to convert a Prefix expression to an Infix expression, I am using a Stack data structure. Since the operators in a prefix expression come before the operands, the best way to process it is by scanning the string from right to left (backwards)."

        2. Step-by-Step Code Walkthrough (The "How")
Ab apne code ke logical blocks ko explain karo:

Initialization: "First, I convert the string into a character array for easy traversal. I initialize a Stack (using ArrayDeque for better performance) to hold intermediate string results."

Reverse Iteration: "I loop through the array from the last character to the first (length-1 down to 0)."

Handling Operands: "Inside the loop, I check if the current character is an operand (a letter or a digit). If it is, I simply push it onto the stack as a String."

Handling Operators: "If the character is an operator, it means the top two elements in my stack are its corresponding operands.

I pop the first element as my left operand (l).

I pop the second element as my right operand (sl).

Then, I combine them in the Infix format: ( + left_operand + operator + right_operand + ).

Finally, I push this newly formed string back onto the stack."

Final Result: "Once the loop finishes, the stack will contain exactly one element, which is our fully formatted Infix expression. I pop and return it."

 3. Complexity Analysis Zarur Batan (Bonus Points)
Interviewer hamesha Time aur Space complexity puchega. Agar tum khud se pehle bata doge, toh bahut accha impression padega:

Time Complexity: O(N). "We are traversing the string of length N exactly once. (Note: String concatenation takes some time, but overall traversal is linear)."

Space Complexity: O(N). "In the worst case, if the expression contains all operands followed by all operators, our stack will store all N/2 operands. The output string also takes O(N) space."
*/