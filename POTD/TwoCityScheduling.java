package POTD;

public class TwoCityScheduling {
}
/*
class Solution {
    public int twoCitySchedCost(int[][] costs) {


        int n = costs.length;
        int[][] diff = new int[n][2];
        int sum = 0;

        // assume we are sending all the persons to city A
        for( int i = 0 ; i < n ; i++ ){
            sum += costs[i][0];

            // difference - now we need to choose n/2 persons such that they reduce our spending amount
            // directly bole toh - > vo person jinka cost of A city - cost of B city = [ city A refund - city B pay ] = saving -> maximum

            diff[i][0] = costs[i][0] - costs[i][1];    // amount we will save at i th person  || +ve good || -ve bad
            diff[i][1] = i;   // person number
        }

        Arrays.sort( diff, (a,b)-> Integer.compare( b[0], a[0]) );

        for( int i = 0; i< n/2; i++ ){

            int ind = diff[i][1];  // vo banda jo maximum saving krayega

            // taking refund from the i th person [ because call back from city A ]
            sum -= costs[ind][0];
            // but send to city B ... so paying for city b ticket
            sum += costs[ind][1];
        }

        return sum;
    }
}

 */