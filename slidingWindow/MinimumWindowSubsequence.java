package slidingWindow;
//idea
//first do forward traversal when pointer reach end of t means subsequnce found containing t
// now job is to find the minimum subsequenc
// for that do the backward travesal
//if nothig found return ""


//time O(S) * O(T)


class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        // code here

        if( s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || s2.length() > s1.length()  )
            return "";

        int minStart = -1;
        int minLen = Integer.MAX_VALUE;
        //pointer for traversing the Strings
        int p1 = 0;
        int p2 = 0;

        int n2 = s2.length();

        //expanding window
        while( p1 < s1.length() ){

            if( s1.charAt(p1) == s2.charAt(p2) ){
                p2++;
            }

            //s2 is fully traversed
            if( p2 == n2 ){
                //returning the starting point
                int start = backwardTraversal(s1,s2,p1);

                if( p1 - start + 1 < minLen ){
                    minStart = start;
                    minLen = p1-start+1;
                }
                p1 = start;
                p2 = 0;

            }

            p1++;
        }

        return minStart == -1 ? "" : s1.substring( minStart, minStart + minLen  );
    }

    //helper function to find minimum valid window
    private static int backwardTraversal(String s1, String s2, int p1){
        //these pointers will traverse from back
        int i = p1;
        int j = s2.length()-1;

        while(i >= 0){
            //same character means reduce index
            if( s1.charAt(i) == s2.charAt(j) )   j--;
            if( j == -1 ) return i;
            i--;

        }

        //guranteed match will be found
        return -1;
    }
}
