package slidingWindow;


class MaximumPoints {
    public int maxScore(int[] cardPoints, int k) {

        if( cardPoints == null || cardPoints.length == 0 || k == 0 || k > cardPoints.length ) return 0;

        int n = cardPoints.length;

        int sum = 0;

        for( int i = 0 ; i < k ; i++ ){
            sum += cardPoints[i];
        }

        int maxSum = sum;

        for( int i = 0 ; i < k ; i++ ){

            sum -= cardPoints[k-1-i];
            sum += cardPoints[n-1-i];
            maxSum = Math.max( sum, maxSum );
        }
        return maxSum;

    }
}