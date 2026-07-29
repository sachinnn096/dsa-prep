package Recursion.partioningPattern;


import java.util.ArrayList;
import java.util.List;

class Partition {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        partition( 0,s,new ArrayList<>(),result );
        return result;

    }




    private void partition( int start,String s,List<String> current,List<List<String>> result ){
        //algo
        //start = starting of string jha se cut mara jaayega
        //end =  loop yha loop chalege jo btayege ke kha cut mara gya h ...end index of piece 1
        //then remaing string k liye recursive call maro    end+1 index send krke


        if( start == s.length() ){
            //means poore string ko sub continous sub pieces main divide kr chuke h
            result.add( new ArrayList<>( current ) );
            return;
        }


        for( int end = start;end<s.length();end++ ){

            //yha cut maarna h
            // y loop har index ko mauka dete h cut maarne ka

            String currPart = s.substring( start,end+1 );

            if( !isValid( currPart ) ) continue;

            current.add( currPart );

            partition( end+1,s,current,result );

            //backtrack
            current.remove( current.size()-1 );
        }


    }



    public boolean isValid( String s ){

        char arr[]  = s.toCharArray();

        int i = 0;
        int j = arr.length-1;

        while( i<j ){
            if( arr[i]!=arr[j] ) return false;

            i++;j--;
        }
        return true;
    }
}