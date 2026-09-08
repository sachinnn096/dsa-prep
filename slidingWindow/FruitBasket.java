package slidingWindow;

import java.util.HashMap;

class FruitBasket {
    public int totalFruit(int[] fruits) {


        int maxlen = 0;
        int n = fruits.length;
        //left boundary
        int left = 0;
        // this array will hold the two fruits types
        int basket1 = -1;
        int b1 = -1;
        int basket2 = -1;
        int b2 = -1;

        //stores the index of last occurence of fruit type
        HashMap<Integer,Integer> map = new HashMap<>();


        for( int right = 0 ; right < n ; right++ ){

            int fruitType = fruits[right];

            //if basket1 is empty or fruit same as basket 1
            if( basket1 == -1 || fruitType == basket1 ) {
                basket1 = fruitType;
                b1 = right;

                //if basket2 is empty or fruit same as basket 2
            }else if( basket2 == -1 || fruitType == basket2  ){
                basket2 = fruitType;
                b2 = right;
                //fruit not present in any basket
            }else{

                if( b1<b2 ){
                    left = b1+1; //updating boundary
                    basket1 = fruitType;  //placing new fruit into basket1
                    b1 = right;

                }else{
                    left = b2+1;
                    basket2 = fruitType;
                    b2 = right;
                }
            }
            maxlen = Math.max( maxlen, right-left+1 );
        }

        return maxlen;

    }
}