public class Boundary {
}

/*
    left side = left boundary + leaf[left -> right]
    idea -> jab tumhe phela null milega ? kya uss time left boundary k saare nodes acess ho chuke honge

    ans - no , ex  A.left-> B , B.left = null but B.right = c
    now hamara preorder call krega left left left...
    so use B.left = null mil jaayega & we assume we have covered all left boundaries

    but B.right = c hai vo toh cover na hue [ c is a part of left boundary ]

    //idea -> add all nodes untill you find first leaf
        then only add leaf nodes
        similiarly in right boundary

 */


/*
class Boundary {

    private boolean leftLeaf ;
    private boolean rightLeaf;

    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here


        ArrayList<Integer> boundary = new ArrayList<>();
        if( root == null ) return boundary;

        leftLeaf = false;
        rightLeaf = false;
        boundary.add( root.data );  //adding root node

        // processing left boundary + leaf
        leftBoundary( root.left,boundary );

        Deque<Integer> stack = new ArrayDeque<>();
        // processing right boundary + leaf
        rightBoundary( root.right,stack );

        while( !stack.isEmpty() ){
            boundary.add( stack.pop() );
        }

        return boundary;
    }


    //getting left boundary
    private void leftBoundary( Node root,ArrayList<Integer> boundary ){

        if( root == null ) return;

        //when we found first leaf , means all left boundary accessed
        if( isLeaf( root ) ){
            boundary.add( root.data);
            leftLeaf = true;
        }
        if( !leftLeaf ){
            boundary.add( root.data );
        }

        //calling recursively
        leftBoundary( root.left,boundary );
        leftBoundary( root.right,boundary );


    }
    private void rightBoundary( Node root,Deque<Integer> stack ){

        if( root == null ) return;

        //when we found first leaf , means all right boundary accessed
        if( isLeaf( root ) ){
            stack.push( root.data);
            rightLeaf = true;
        }

        if( !rightLeaf ) stack.push( root.data );
        //calling recursively
        rightBoundary( root.right, stack );
        rightBoundary( root.left, stack );

    }

    private boolean isLeaf( Node root ){
        return root.left == null && root.right == null;
    }
}

 */





//standard approach
/*
class Solution {

    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here


        ArrayList<Integer> boundary = new ArrayList<>();
        if( root == null ) return boundary;

        //what if root is leaf // it will be added double time in list
        if( !isLeaf( root ) ){
            boundary.add( root.data );
        }


        addLeftBoundary( root.left, boundary );
        addLeaves( root, boundary );
        addRightBoundary( root.right,boundary );

        return boundary;
    }


    public void addLeftBoundary( Node root ,ArrayList<Integer> boundary ){
        //finding left leaf iteratively
        if( root == null ) return;

        while( !isLeaf( root ) ){
            boundary.add( root.data );

            if( root.left != null )
                root = root.left;
            else root = root.right;
        }
    }
    public void addRightBoundary( Node root ,ArrayList<Integer> boundary ){
        //finding left leaf iteratively
        if( root == null ) return;
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        while( !isLeaf( root ) ){
            stack.push( root.data );

            if( root.right != null )
                root = root.right;
            else root = root.left;
        }


        while( !stack.isEmpty() ){
            boundary.add( stack.pop() );
        }
    }

    //getting left boundary
    private void addLeaves( Node root,ArrayList<Integer> boundary ){

        if( root == null ) return;

        if( isLeaf( root ) ){
            boundary.add( root.data);
        }

        addLeaves( root.left,boundary );
        addLeaves( root.right,boundary );
    }


    private boolean isLeaf( Node root ){
        return root.left == null && root.right == null;
    }
}
 */


