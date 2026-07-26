package Recursion.permutation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class Permutation1 {
    public List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();


        permutations( 0,nums,result,new ArrayList<>() );
        return result;

    }


    private void permutations( int idx,int nums[],List<List<Integer>> result,List<Integer> current ){

        //base case

        if( idx == nums.length ){
            result.add( new ArrayList<>( current ) );
            return;
        }

        for( int i = idx;i<nums.length;i++ ){

            //giving chance to the every character to appear first // fixed krrhe h
            swap( nums,idx,i );
            current.add( nums[idx] );
            permutations( idx+1,nums,result,current );
            //backtrack
            swap( nums,idx,i );
            current.remove( current.size()-1 );
        }

    }


    public void swap( int nums[],int i,int j ){
        if( i==j ) return;

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}