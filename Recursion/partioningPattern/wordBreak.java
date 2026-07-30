package Recursion.partioningPattern;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        return backtrack( 0,s, new HashSet<>( wordDict ));

    }

    private boolean backtrack( int start,String s,Set<String> dict ){

        //base case
        if( start == s.length() ) return true;

        //finding the left most part of string that lies in the dict

        for( int end = start;end<s.length();end++ ){

            //find left most part
            String left = s.substring( start,end+1 );

            if( !dict.contains( left ) ) continue;


            //calling for remaining string
            if( backtrack( end+1,s,dict ) ) return true;

        }

        return false;

    }
}



//class wordBreak {
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        int maxLen = 0;
//        Set<String> dict = new HashSet<>();
//
//        for( String curr:wordDict){
//            maxLen = Math.max( maxLen,curr.length() );
//            dict.add( curr );
//        }
//
//        return backtrack( 0 , s , dict , maxLen );
//
//    }
//
//    private boolean backtrack( int start,String s,Set<String> dict,int maxLen ){
//
//        //base case
//        if( start == s.length() ) return true;
//
//        //finding the left most part of string that lies in the dict
//
//        int limit = Math.min( start+maxLen,s.length() );
//
//
//        for( int end = start ; end<limit ; end++ ){
//
//            //find left most part
//            String left = s.substring( start,end+1 );
//
//            if( !dict.contains( left ) ) continue;
//
//
//            //calling for remaining string
//            if( backtrack( end+1,s,dict,maxLen ) ) return true;
//
//        }
//
//        return false;
//
//    }
//}