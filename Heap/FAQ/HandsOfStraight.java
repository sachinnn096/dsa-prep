package Heap.FAQ;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        // 1. Array ko sort kar do -> O(N log N)
        Arrays.sort( hand );

        Map<Integer,Integer> map = new HashMap<>();
        //counting freq of characters
        for( int i : hand ){
            map.put( i, map.getOrDefault( i, 0 )+1 );
        }

        // find minimum card available
        for( int card : hand ){

            int freq = map.get( card );
            //card not available , go ahead
            if( freq <= 0 ){
                continue;
            }
            //got minimum card , now  form group
            for( int i = 0 ; i < groupSize ; i++ ){

                int newCard = card + i;
                int count = map.getOrDefault( newCard, 0 );

                if( count <= 0 ){           //group can't be formed bcz of unavailability of card
                    return false;
                }
                map.put( newCard , count - 1 );
            }
        }
        return true;
    }
}