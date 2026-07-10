import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        List<List<Integer>> res = new ArrayList<>();

//duplicates value pass pass aajayenge  ...skip krne main useful
        Arrays.sort( candidates );

        solve(0,candidates,target,new ArrayList<Integer>(),res);
        return res;

    }

    public void solve( int idx,int candidates[],int target,List<Integer> temp,List<List<Integer>> res )
    {
        //base case
        if( target<0 ) return ;
        if( target == 0 ){
            res.add( new ArrayList<>(temp) );
            return;
        }

        //taking care of the logic to remove duplicates combination
        //same level pr element skip krna h ....recusrive call main ni krna( kr skte )
        //har index ko root bna kr explore krrhe h
        for( int i = idx;i<candidates.length;i++ ){

            //code
            if( i>idx && candidates[i] == candidates[i-1] ) continue;

            temp.add( candidates[i] );
            solve( i+1,candidates,target-candidates[i] , temp,res );

            //backtrack
            temp.remove( temp.size()-1 );

        }
    }

}