package stack;

//time complexity = n
//space complexity = 1

//hint 2 pointer approach
//for more hints go down
class CelebrityProblemOptimized {
    public int celebrity(int mat[][]) {
        // code here

        if( mat == null || mat.length == 0 ) return -1;
        //approach
        //1. traverse from left to right and choose every person one by one as a celebrity
        int n = mat.length;

        if( n == 1 ) return 0;

        //ith person is choosed as celebrity

        int left = 0;
        int right = n-1;


        while( left < right ){
            //case 1 either both knows each other or no one
            if( mat[left][right] == 1  ){

                left++;

                //case 2 & 3
            }else{
                right--;
            }

        }

        int candidate = left;

        //verfying the remaining candidate...is it a celebrity or not

        for( int i = 0 ; i < n ; i++ ){
            if( candidate == i  ) continue;

            //if it knows anyone or  not known by everyone ...its not a celebrity
            if( mat[candidate][i] == 1  || mat[i][candidate] == 0 ) return -1;
        }

        return candidate;
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

