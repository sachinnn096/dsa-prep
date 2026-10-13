package BinaryTree;

public class BurnTreeTime {
}


/*

 /* logic
        find target node
            find height from target to bottom side [ height = time taken to burn tree with target node as root node ]
        now we need to burn the tree which is upward from target & its left / right subtree

        postorder
            why -> will tell us height from the bottom of left / right subtree
                    will tell us the do really the target node is found in any left / right subtree

 */




/*


class Solution {

    class Pair{
        int height;
        int distanceFromTarget;

        public Pair( int x,int y ){
            this.height = x;
            this.distanceFromTarget = y;

        }
    }

    private int maxtime;


    public int minTime(Node root, int target) {
        // code here
        maxtime = 0;

        if( root == null )
            return -1;  // target node not found so tree can not be set to fire


        dfs( root,target );
        return maxtime;


    }

    public Pair dfs( Node root,int target ){

        if( root == null ){
            return new Pair( 0, -1 ); // height , target status
        }

        //bottom up
        Pair left = dfs( root.left,target );
        Pair right = dfs( root.right, target );

        // bottom - > up
        if( root.data == target ){
            // maximum time taken to burn the tree from target node to bottom tree
            maxtime = Math.max( maxtime, Math.max( left.height,right.height ) );

            return new Pair( Math.max( left.height,right.height )+1, 1 );  //returning to parent

        }

        // target is found in left subtree
        if( left.distanceFromTarget != -1 ){
            // how much time will the right subtree take to burn completely from target node

            maxtime = Math.max( maxtime, left.distanceFromTarget + right.height );

            return new Pair( Math.max( left.height,right.height )+1, left.distanceFromTarget+1 );
        }

        // target found in rightsubtree
        if( right.distanceFromTarget != -1 ){

            maxtime = Math.max( maxtime, right.distanceFromTarget + left.height );

            return new Pair( Math.max( left.height,right.height )+1, right.distanceFromTarget+1 );
        }

        // target neither found in left , right subtree and also not equla to current node
        return new Pair( Math.max( left.height,right.height )+1, -1 );


    }
}

*/