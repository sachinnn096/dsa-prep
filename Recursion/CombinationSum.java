import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> ans = new ArrayList<>();
        solve( 0,candidates.length,candidates,ans,new ArrayList<Integer>(),target );
        return ans;

    }


    public void solve( int idx,int n,int arr[],List<List<Integer>> ans,List<Integer> temp, int target ){
        //base case
        if( target == 0 ){
            ans.add( new ArrayList<>(temp) );
            return;
        }
        if(target<0 )  return;


        //now giving chance to everyone
        //idx tells the point from where we need to take elements
        for( int i = idx;i<n;i++ ){
            temp.add( arr[i] );
            solve( i,n,arr,ans,temp,target-arr[i] );


            //backtracking
            temp.remove( temp.size()-1 );
        }

    }
}