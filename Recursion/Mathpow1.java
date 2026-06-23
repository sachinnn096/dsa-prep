class Mathpow1 {
    public double myPow(double x, int n) {

        if( n == 0 ) return 1;
        if( x == 0 ) return 0;

        if( n<0 ) x =  1/x;
        long nn = Math.abs((long)n);

        return findpow(x,nn);

    }


    public static double findpow(double x,long n){
        //base case

        if( n == 0 ) return 1;

        if( n % 2 == 1 )
            return x*findpow(x,n-1);
        else return findpow(x*x,n/2);
    }
}