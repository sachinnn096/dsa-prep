package stack;

//time complexity = n
//space complexity = 1

//hint 2 pointer approach
//for more hints go down

class CelebrityProblemOptimized {
    public int celebrity(int mat[][]) {
        // code here


        //approach
        //1. traverse from left to right and choose every person one by one as a celebrity

        int n = mat.length;

        //ith person is choosed as celebrity

        int left = 0;
        int right = n-1;


        while( left < right ){
            //case 1 either both knows each other or no one
            if( mat[left][right] == 1 && mat[right][left] == 1 || mat[left][right] == 0 && mat[right][left] == 0 ){

                left++;
                right--;

                //case 2 & 3
            }else if( mat[left][right] == 1 ){
                left++;

            }else{
                right--;
            }

        }

        if( left > right ) return -1;

        int candidate = left;

        //verfying the remaining candidate...is it a celebrity or not

        for( int i = 0 ; i < n ; i++ ){
            if( candidate == i  ) continue;

            //if it knows anyone or  not known by everyone ...its not a celebrity
            if( mat[candidate][i] == 1  || mat[i][candidate] == 0 ) return -1;
        }

        return candidate;
    }

    boolean know( int first, int second, int[][] matrix ){

        if( matrix[first][second] == 1 ) return true;
        return false;
    }
}


// compare any two elements and eleminate the one
//now think how can you move pointer in such a way untill everyone is eleminated or celebrity is found


//celebrity can be known by everyone
// a->b means a cant be but b can


//imp case compare any two
// if a know b means a can't be celebrity ...but may be b can be
//or if a does not know b means b can't be celebrity...and a can be
// b-a

