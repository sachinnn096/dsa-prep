class Mathpow2 {
    public double myPow(double x, int n) {

        //iterative approach se krunga

        if( n<0 ) x = 1/x;
        if( n == 0 ) return 1;
        if(x == 0) return 0;

        double ans = 1;
        long nn = Math.abs( (long)n );

        // while( nn>0 ){
        //     if( nn%2 == 0 ){
        //         x = x*x;
        //         nn = nn/2;
        //     }else{
        //         ans = ans*x;
        //         nn = nn-1;
        //     }
        // }

        while(nn!=1){

            if( nn%2 == 1 )
                ans = ans*x;

            x = x*x;
            nn = nn/2;

        }
        return ans*x;

    }
}

//time complexity = logn
//space complexity  = 1;

