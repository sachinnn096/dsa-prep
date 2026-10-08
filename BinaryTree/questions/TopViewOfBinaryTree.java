package BinaryTree.questions;

public class TopViewOfBinaryTree {
}





///     hint - think of in terms of 2d matrix [ row,col]

/*
class Solution {

    //helper class
    class Cell{
        int col;
        Node node;

        public Cell( int col,Node node ){
            this.col = col;
            this.node = node;
        }
    }



    public ArrayList<Integer> topView(Node root) {
        // code here

        if( root == null ) return new ArrayList<>(); //NOTHING CASE
        return bfs( root );

    }

    //breath first search
    public ArrayList<Integer> bfs( Node root){

        //store column, topmost value
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Cell> q = new ArrayDeque<>();

        //pushing the root node for starting bfs
        q.offer( new Cell( 0, root ) );

        //keeping track of minimum column value & maximum column value
        // so mincol -> maxCol [ maintaining top view order ]
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        while( !q.isEmpty() ){

            //here level by level traversal is not required
            Cell c = q.poll();
            Node n = c.node;
            int col = c.col;


            if( !map.containsKey( col ) )
                map.put( col, n.data );

            // push left child
            if( n.left != null )
                q.offer( new Cell( col-1, n.left ));
            // push right child
            if( n.right != null )
                q.offer( new Cell( col+1, n.right ));

            minCol = Math.min( minCol, col );
            maxCol = Math.max( maxCol, col );


        }
        //ordering the topview
        return prepareTopView( map, minCol, maxCol );


    }
    public ArrayList<Integer> prepareTopView( Map<Integer,Integer> map, int min , int max ){

        ArrayList<Integer> topView = new ArrayList<>();

        // traversing from left most column to rightmost column[ Now No need of sorting , complexity reduced from O(N * logN) -> O(N) ]
        for( int i = min ; i <= max ; i++ ){
            topView.add( map.get( i ) );
        }
        return topView;

    }

}

 */