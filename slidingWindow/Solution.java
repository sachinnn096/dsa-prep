package slidingWindow;


class Solution {
    public String minWindow(String s, String t) {


        if( s.isEmpty() || t.isEmpty() || t.length() > s.length() ) return "";



        //tell how many character of t are still not present in subarray of s
        int remainingChars = t.length();
        int left = 0;

        int start = -1;    // point to starting index of subarray
        int end = -1;      // point to ending index of subarray

        // store freq of charcters of string t
        int[] freq = new int[256];

        // counting frequency of character of t string
        for( int i = 0 ; i < t.length() ; i++ )
            freq[ t.charAt(i) ]++;

        //choosing starting point of subarray
        for( int right = 0 ; right < s.length() ; right++ ){

            int ind = s.charAt(right);

            if( freq[ind] > 0 ) remainingChars--;

            freq[ind]--;

            //shrinking for mininum window untill current window is invalid
            while( remainingChars <= 0 ){

                if(  isMininmumWindowEmpty(end) || isThisSubArraySmaller( start, end, left, right ) ){
                    start = left;
                    end = right;
                }

                int leftIndex = s.charAt( left );
                freq[ leftIndex ]++;

                if( freq[ leftIndex ] > 0 ) remainingChars++;
                left++;
            }

        }

        return end == -1 ? "" : s.substring( start, end+1 );
    }

    public boolean isMininmumWindowEmpty(int end){
        return end == -1;
    }

    public boolean isThisSubArraySmaller( int start, int end, int left, int right ){
        return (right-left+1) < (end - start + 1);
    }
}


//key takeaway
//1 dont create instance variable , use local variables only always
//2 don calculate the s.subtring method again and again maintain pointers
//use function to do sub tasks---helper function
