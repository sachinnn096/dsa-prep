package stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//hint
//max freq wala hamesh pop hoga
// in case multiple elements with same freq...recently(stack) pushed pop hoga

//ex 6 4 6 5 4 3
// 6-2
// 4-2
// 5-1
// 3-1
// ab yha 6 & 4 ke frequency same h toh recenlty pushed means 4 pop hoga

class MaximumFrequencyStack895 {

        ArrayList<ArrayDeque<Integer>> list;
        Map< Integer, Integer > map;

        //point to elements of stack those have highest frequency always
        int maxIndex;


        public MaximumFrequencyStack895() {
            //
            list = new ArrayList<>();
            //zero index
            list.add( new ArrayDeque<Integer>() );
            maxIndex = 0;

            //intializing the map
            map = new HashMap<>();
        }

        public void push(int key) {

            int freq = map.getOrDefault( key , 0 )+1;
            //putting/updating the element with frequency
            map.put( key, freq );

            //adding the arraylist for storing elements with freq at index of list freq
            if( freq >= list.size() ){
                maxIndex++;
                list.add( new ArrayDeque<>() );
            }

            //adding element
            list.get( freq ).push( key );

        }

        public int pop() {

            //fetching the list with elements of maximum freq
            //fetching recently pushed element
            int removedValue = list.get(maxIndex).pop();

            int freq = map.get( removedValue );
            //reducing the frequency
            if( freq == 1 )
                map.remove( removedValue );
            else
                map.put( removedValue, freq-1 );


            //arraylist got empty...remove this arraylist
            if( list.get(maxIndex).isEmpty() ){
                list.remove( maxIndex );
                maxIndex--;
            }

            return removedValue;

        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */