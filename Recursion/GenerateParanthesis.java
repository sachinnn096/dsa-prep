import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {

        //edge case
        List<String> anslist  =  new ArrayList<>();
        if( n == 0 ) return anslist;

        solve( 0,n*2,0,new StringBuilder(),anslist );
        return anslist;



    }

    public void solve(int idx, int n, int count, StringBuilder sb,List<String> anslist){

        //base case
        if( idx == n ){
            //inner base case
            if( count == 0 ) anslist.add( sb.toString() );
            return;
        }



        //case 1
        sb.append( "(" );
        count++;
        solve( idx+1,n,count,sb,anslist );
        //backtrack first
        sb.deleteCharAt( sb.length()-1 );
        count--;

        //case 2
        if( count>0 ){

            sb.append(")");
            count--;
            solve( idx+1,n,count,sb,anslist );
            //backtrack
            sb.deleteCharAt( sb.length()-1 );
            count++;

        }


    }
}