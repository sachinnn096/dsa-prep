class PrintNaturalNumber1 {
    public static void main(String[] args) {

        new PrintNaturalNumber1().print(7);


    }



    //que print the natural number by recursion n natual numbers
    // in the order 1 2 3 4 5 6 7 8 9 ,   N = 9


    public void print(int n){
        if( n == 0 ) return;

        print(n-1);   //recursive call

        System.out.print(n+" ");
    }
}