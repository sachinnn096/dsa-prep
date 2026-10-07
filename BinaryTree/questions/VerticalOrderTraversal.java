package BinaryTree.questions;

public class VerticalOrderTraversal {
}


/*

class Solution {

    //helper class
    class Node{
        int row;
        int col;
        int value;

        public Node( int row, int col, int value ){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {


        List<List<Integer>> ans = new ArrayList<>();
        if( root == null ) return ans;
        if( root.left == null && root.right == null ){
            ans.add( List.of(root.val) );
            return ans;
        }

        List<Node> cells = new ArrayList<>();

        //storing all the nodes into list using dfs( preorder )
        dfs( root, 0, 0, cells );

        Collections.sort( cells, (a,b)->{
            if( a.col != b.col ) return Integer.compare( a.col, b.col );
            else if( a.row != b.row ) return Integer.compare( a.row, b.row );
            else return Integer.compare( a.value, b.value );

        } );

        int currColumn = cells.get(0).col;


        ans.add( new ArrayList<>() );

        for( int i = 0 ; i < cells.size() ; i++ ){

            Node temp = cells.get(i);
            int c = temp.col;

            if( c != currColumn ){
                ans.add( new ArrayList<>() );
                currColumn = c;
            }
            ans.get( ans.size()-1 ).add(temp.value);
        }
        return ans;


    }

    public void dfs( TreeNode root,int row,int col,List<Node> cells ){

        if( root == null ) return;

        cells.add( new Node( row,col,root.val ) );

        dfs( root.left, row+1, col-1, cells );
        dfs( root.right, row+1, col+1, cells );


    }
}

 */