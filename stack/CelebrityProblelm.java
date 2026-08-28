package stack;


class CelebrityProblelm {
    public int celebrity(int mat[][]) {
        // code here


        //approach
        //1. traverse from left to right and choose every person one by one as a celebrity

        int n = mat.length;

        //ith person is choosed as celebrity
        for( int i = 0 ; i < n ; i++ ){

            boolean isCelebrity = true;

            //asking other peoples weather they know the person i or not
            for( int j = 0 ; j < n ; j++ ){
                if( i == j ) continue;

                //if person j does not know person i ...means it cant be celebrity
                if( !know( j, i,mat ) ) isCelebrity = false;

                //if person i knows person j means i can't be a celebrity
                if( know( i, j, mat ) ) isCelebrity = false;

                if( !isCelebrity ) break;

            }

            if( isCelebrity ) return i;

        }
        return -1;
    }

    boolean know( int first, int second, int[][] matrix ){

        if( matrix[first][second] == 1 ) return true;
        return false;
    }
}