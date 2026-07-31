package Recursion.partioningPattern;


class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {

        List<String> result  = new ArrayList<>();

        restoreIpAddresses( 1,0,result,new ArrayList<>(),s.toCharArray() );
        return result;



    }


    private void restoreIpAddresses( int part,int start,List<String> result,List<Integer> current ,char arr[] ){


        //base case 1
        if( part == 5 ){
            if( start == arr.length ){
                //fetch the number ...seprate it with . operator then add to result
                StringBuilder sb = new StringBuilder();

                for( int i:current ) sb.append( i+"." );

                sb.deleteCharAt( sb.length()-1 );
                result.add( sb.toString() );
            }
            return;
        }

        //base case2
        if( part < 5 && start >= arr.length ) return;

        //if the current char is 0  ...make a call to another func...because the leading value cant be zero

        if( arr[start] == '0' ){

            current.add( 0 );
            restoreIpAddresses( part+1,start+1,result,current,arr );
            //backtrack
            current.remove( current.size()-1 );

        }
        else{
            int num = 0;
            for( int end = start ; end < arr.length ; end++ ){
                num = num*10+( arr[end]-'0' );

                if( num > 255 ) return;

                current.add( num );
                restoreIpAddresses( part+1,end+1,result,current,arr );
                //backtrack
                current.remove( current.size()-1 );


            }
        }


    }
}
