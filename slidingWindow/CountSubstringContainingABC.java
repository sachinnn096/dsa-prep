package slidingWindow;


import java.util.HashMap;
import java.util.Map;

class CountSubstringContainingABC {
    public int numberOfSubstrings(String s) {

        if( s == null || s.isEmpty() || s.length() < 3 ) return 0;

        int count = 0;

        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;

        //expanding the window to find valid substring containing all three chars abc
        for( int r = 0 ; r < n ; r++ ){

            char c = s.charAt(r);
            map.put( c , map.getOrDefault( c , 0 ) + 1 );

            //finding how many subarrays can be formed with first valid window

            //couting right side valid subarrays
            //counting subarrays from the window itself by shrinking it untill window becomes invalid
            while( map.size() >= 3 ){

                count += n-r;

                char curr = s.charAt(left);

                map.put( curr,map.get( curr )-1 );
                if( map.get( curr ) == 0 ) map.remove( curr );
                left++;

            }
        }

        return count;
    }
}