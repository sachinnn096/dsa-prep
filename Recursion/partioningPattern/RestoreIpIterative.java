package Recursion.partioningPattern;



class RestoreIpIterative {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();


        int n = s.length();
        //means no ip add can be formed
        if( n<4 || n>12 ) return result;

        //looping iteration

        for( int i = 0;i<Math.min( 3,n );i++ ){
            for( int j = i+1; j<Math.min( i+1+3,n );j++ ){
                for( int k = j+1; k< Math.min( j+1+3,n ); k++ ){

                    int remainingLengthOfString = n-k-1;

                    if( remainingLengthOfString<=0 || remainingLengthOfString >3 ) continue;

                    String s1 = s.substring( 0,i+1 );
                    String s2 = s.substring( i+1,j+1 );
                    String s3 = s.substring( j+1,k+1 );
                    String s4 = s.substring( k+1,n );

                    if( isValid( s1 ) && isValid( s2 )  && isValid( s3 ) && isValid( s4 ) )
                        result.add( String.join( ".",s1,s2,s3,s4 ) );


                }
            }
        }

        return result;
    }

    private boolean isValid( String s ){
        if( s.length()>1 && s.charAt( 0 ) == '0' ) return false;

        int num = Integer.parseInt( s );
        if( num>255 ) return false;
        return true;

    }
}