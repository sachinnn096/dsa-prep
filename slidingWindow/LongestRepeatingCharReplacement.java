package slidingWindow;



//idea - for a string to find it could be possible answer
//find the char with max frequency
// s.length - maxFreq =  no of chars that are needed to be changed in order to convert this string(baaab) to string with same character( aaa )

class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {

        //AAABBAB k = 2

        if( s == null ) return 0;
        int n = s.length();
        if( k >= n ) return n;

        int maxLen = 0;
        int[] freq = new int[26];
        int left = 0;

        int maxFreq = 0;

        for( int right = 0 ; right < n ; right++ ){

            int index = s.charAt(right) - 'A';
            freq[index]++;

            if( freq[index] > maxFreq   ) maxFreq = freq[index];

            //making the window valid
            //if no of char need to modified are greater than k ...squeeze the window
            while( (right - left + 1) - maxFreq > k  ){
                freq[ s.charAt( left )-'A' ]--;
                left++;

                //looking for new char with maximum frequency
                for( int i = 0 ; i < 26 ; i++ ) maxFreq = Math.max( maxFreq,freq[i] );
            }

            //storing the length
            maxLen = Math.max( maxLen ,right-left+1 );
        }

        return maxLen;
    }
}