package BST;

public class TwoSumInBST {
}


/**

 preq - > how to perform inorder iteratively[ BST Iterator ]


 think of it as taking two pointers on a sorted array
 i on the smallest [ 0 th ]
 j on the largest [ n-1 th ]
 now trying to find two values with sum target how ?
 */


/*
class Solution {
    public boolean findTarget(TreeNode root, int k) {

        if( root == null ) return false;


        Deque<TreeNode> A = new ArrayDeque<>();  // forward branch
        Deque<TreeNode> B = new ArrayDeque<>();  // backward branch

        inorderHelper( root,A );
        reverseInorderHelper(root,B);
        // base case
        while( A.peek().val < B.peek().val ){

            // case 1 sum > target --- move right pointer toward left
            if( A.peek().val + B.peek().val > k ){
                TreeNode curr = B.pop();
                reverseInorderHelper( curr.left,B );
            }
            // case 2 sum < target  --- move left pointer toward right
            else if(  A.peek().val + B.peek().val < k ){
                TreeNode curr = A.pop();
                inorderHelper( curr.right,A );
            }
            else return true;

        }
        return false;
    }


    // explore the left most branch
    public void inorderHelper( TreeNode root, Deque<TreeNode> A ){
        // go as left as possible inorder[ left root right ]

        //exploring leftMost branch
        while( root != null ){
            A.push( root );
            root = root.left;
        }

    }

    // explore the right most branch
    public void reverseInorderHelper( TreeNode root, Deque<TreeNode> B ){
        // go as left as possible inorder[ left root right ]

        //exploring leftMost branch
        while( root != null ){
            B.push( root );
            root = root.right;
        }

    }
}
 */