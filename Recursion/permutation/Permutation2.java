package Recursion.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result  = new ArrayList<>();

        //sorting is mandatory
        Arrays.sort( nums );
        boolean visited[] = new boolean [nums.length];
        permutation2( nums,result,new ArrayList<>(),visited );
        // Collections.sort( result );

        return result;
    }

    private void permutation2( int nums[],List<List<Integer>> result,List<Integer> current,boolean visited[] ){

//base case
        if( current.size() == nums.length ){

            result.add( new ArrayList<>( current ) );
            return;
        }


        //giving chance to every element to appear at index 0 for once

        for( int i = 0;i<nums.length;i++ ){

            //skip condition
            // if( i>0 && !visited[i] && nums[i] == nums[i-1] && !visited[i-1] )
            //     continue;

            if( !visited[i] ){

                if( i>0 && nums[i] == nums[i-1] && !visited[i-1] ) continue;

                visited[i] = true;
                current.add( nums[i] );

                permutation2( nums,result,current,visited );

                current.remove( current.size()-1 );
                visited[i] = false;

            }
        }

    }

}
