import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> maxheap = new PriorityQueue<>( Collections.reverseOrder() );

        int[] freq = new int[26];
        //counting the frequencies of character
        for( char c : tasks ){
            freq[ c - 'A' ]++;
        }

        //adding the freq of characters into maxheap
        for( int i:freq ){
            if( i > 0 ) maxheap.offer( i );
        }

        int interval = 0;

        //always trying to make window start with  character with highest frequency
        while( true ){


            List<Integer> temp = new ArrayList<>();

            //making a window of n+1 ...so the max Freq char can repeat itself
            int i = 1;

            while( i <= n+1 && !maxheap.isEmpty() ){
                interval++;

                int currFreq = maxheap.poll()-1;
                //if this task is not executed fully( any instance remaining )
                if( currFreq > 0 )
                    temp.add( currFreq );

                i++;
            }

            //means all task's are executed and no one is left
            if( temp.size() == 0 && maxheap.isEmpty() )
                return interval;
            //adding the idle time for cooling
            while( i <= n+1 ){
                interval++;
                i++;
            }
            //re adding the remaining instance of task in queue
            for( int remainingInstance : temp ) maxheap.add( remainingInstance );
        }

    }
}