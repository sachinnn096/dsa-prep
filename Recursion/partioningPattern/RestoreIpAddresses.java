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
/*
class Solution {
    public List<String> restoreIpAddresses(String s) {

        //iterative approach
        int n = s.length();

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        char nums[] = s.toCharArray();

        //store answer
        List<String> result = new ArrayList<>();

        //iterative appraoch
        for (int p1 = 0; p1 < Math.min( 3,n ); p1++) {

            //first value
            num1 = num1 * 10 + (nums[p1] - '0');
            if (num1 > 255) break;

            //boundary for second part
            int part2limit = Math.min(p1 +1 + 3, n);
            //second loop
            num2 = 0;
            for (int p2 = p1 + 1; p2 < part2limit; p2++) {

                //second value
                num2 = num2 * 10 + (nums[p2] - '0');
                if (num2 > 255) break;

                int part3Limit = Math.min(p2 + 1 + 3, n);
                //third loop
                num3 = 0;
                for (int p3 = p2 + 1; p3 < part3Limit; p3++) {

                    //third value
                    num3 = num3 * 10 + nums[p3] - '0';
                    if (num3 > 255) break;

                    int part4Limit = Math.min(p3 + 1 + 3, n);

                    //loop fourth
                    num4 = 0;
                    for (int p4 = p3 + 1; p4 < part4Limit; p4++) {

                        num4 = num4 * 10 + nums[p4] - '0';
                        if (num4 > 255) break;

                        //base case
                        if (p4 + 1 == n) {

                            // String ans = String.Join(".", num1, num2, num3, num4);
                            addNumbersToResult( num1,num2,num3,num4,result );

                            // result.add(ans);
                        }
                        if (num4 == 0) break;

                    }

                    //if first char is zero
                    if (num3 == 0) break;
                }

                if (num2 == 0) break;

            }

            //if we found zero at first iteration
            if (num1 == 0) break;

        }


        return result;

    }

    public void addNumbersToResult( int num1,int num2, int num3,int num4,List<String> result ){


        StringBuilder sb = new StringBuilder();
        char dot = '.';
        sb.append( num1 ).append(dot).append( num2 ).append( dot ).append( num3 ).append( dot ).append( num4 );

        result.add( sb.toString() );

    }
}

 */
