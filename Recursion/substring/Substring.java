package Recursion.substring;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Substring {

    public static void main(String args[]){

        String s = "abcde";
//        substringIterativeApproach( s );

//        substringwithRecursion(s);

        List<String> result =  new ArrayList<>();

        substringggsRec( 0,0,new StringBuilder(),result,s );
        System.out.println(result);

    }


    public static void substringggsRec( int start,int end,StringBuilder sb,List<String> result,String s  ){

        if( end == s.length() )
        {
            //now new Substring start from this start index
            //end index will go upto n

            start = start+1;
            end = start;
            sb.setLength(0);
        }

        if( start == s.length()  ) return ;

        sb.append( s.charAt( end ) );
        result.add( sb.toString() );

        substringggsRec( start,end+1,sb,result,s );

    }


    public static void substringwithRecursion( String s){



        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        //substring can start from any index either 0 , 1 ,2 ...
        for( int i = 0;i<s.length();i++ ){
            helper( i,sb,s,list );
        }
        System.out.println(list);


    }

    public static void helper( int idx,StringBuilder sb,String s,List<String> list ){

            //base case
        if( idx == s.length() ) return;

        //adding the current char
        sb.append( s.charAt( idx ) );
        //adding new substring
        list.add( sb.toString() );

        //making recursive call
        helper( idx+1,sb,s,list );
        //backtracking
        sb.deleteCharAt( sb.length()-1  );
    }

    public static void substringIterativeApproach( String s){


        List<String> substrings = new ArrayList<>();

//        StringBuilder sb = new StringBuilder();

        //any point can be the starting point
        for( int i = 0;i<s.length();i++ ){
            StringBuilder sb = new StringBuilder();

            for( int j = i;j<s.length();j++ ){
                sb.append( s.charAt( j ) );
                substrings.add( sb.toString() );

            }

        }



        System.out.println( substrings );
    }
}
