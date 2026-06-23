import java.util.ArrayList;
import java.util.List;

public class GenerateBinarySWithoutCons1 {
    int countStrings(int n) {

        List<String> anslist = new ArrayList<>();

        //base case
        if( n == 0 ) return 0;

        // code here

        findallsubstrings( 0, n,new StringBuilder(),anslist,false );

        return anslist.size();

    }



    public void findallsubstrings( int i, int n,StringBuilder sb, List<String> anslist,boolean previous ){

        //base case
        if( i == n ){

            anslist.add( sb.toString() );
            return;
        }


        //case 1 putting zero

        sb.append( '0' );
        findallsubstrings( i+1, n, sb, anslist, false );
        sb.deleteCharAt( sb.length()-1 );


        //case 2 putting 1 ...but before putting 1 checking previous should not be 1
        if( !previous ){
            sb.append( '1' );
            findallsubstrings( i+1, n, sb, anslist, true );
            sb.deleteCharAt( sb.length() -1 );



        }


    }

    public static void main(String[] args) {

    }
}


//this is code for generating the all the possible strings without consecutive 1s


// class Solution {
//     int countStrings(int n) {

//         List<String> anslist = new ArrayList<>();

//         //base case
//         if( n == 0 ) return 0;

//         // code here

//         findallsubstrings( 0, n,new StringBuilder(),anslist,false );

//         return anslist.size();

//     }



//     public void findallsubstrings( int i, int n,StringBuilder sb, List<String> anslist,boolean previous ){

//         //base case
//         if( i == n ){

//                 anslist.add( sb.toString() );
//                 return;
//         }


//         //case 1 putting zero

//         sb.append( '0' );
//         findallsubstrings( i+1, n, sb, anslist, false );
//         sb.deleteCharAt( sb.length()-1 );


//         //case 2 putting 1 ...but before putting 1 checking previous should not be 1
//         if( !previous ){
//             sb.append( '1' );
//             findallsubstrings( i+1, n, sb, anslist, true );
//             sb.deleteCharAt( sb.length() -1 );



//         }


//     }
// }