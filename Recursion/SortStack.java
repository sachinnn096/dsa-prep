import java.util.Stack;

class SortStack {
    public void sortStack(Stack<Integer> st) {
        // code here

        //appraoch to solve the problem
        //1. remove all the element from the stack recursively
        //2. now backtrack and find the correct pos for element & push into stack

        breakintosubproblem( st );


    }


    public void breakintosubproblem( Stack<Integer> st ){

        if( st.size() == 0 ) return;

        int poppedvalue = st.pop();
        breakintosubproblem(st);

        //backtrack

        findcorrectpositionandpushintostack( poppedvalue, st );


    }


    public void findcorrectpositionandpushintostack( int value,Stack<Integer> st ){

        // case 1
        if( st.size() == 0 || value >= st.peek() ){
            st.push( value );
            return;
        }

        int poppedvalue = st.pop();
        findcorrectpositionandpushintostack( value , st );
        st.push( poppedvalue );


    }
}


//this above code is an recursive approach ...
//time complexity = N^2
//Space complexity = N ---- internal stack
