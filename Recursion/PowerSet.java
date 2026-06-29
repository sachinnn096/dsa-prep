import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PowerSet {
    public List<String> powerSet(String s) {
        // Code here

        List<String> anslist = new ArrayList<>();


        solve( 0,s.length(),new StringBuilder(),s,anslist );

        //treeset(stores unique values only) cannnot be used here..in case of aa
        Collections.sort(anslist);
        return anslist;

    }


    public void solve( int i ,int n, StringBuilder sb, String og, List<String> anslist ){


        //base case
        if( i == n ){
            anslist.add( sb.toString() );
            return;
        }


        char c = og.charAt(i);


        //case 1 take

        sb.append( c );
        solve( i+1,n,sb,og,anslist );
        sb.deleteCharAt( sb.length()-1 );

        //case 2 not take

        solve( i+1,n,sb,og,anslist );



    }
}


//Time complexity = recursive tree + sorting
//                    2^n           + 2^n * log(2^n) = n * 2^n * nlog2
//why extra in...because the string are being compared not numbers;
//
//         = 2^n*n
//space complexity = 2^n