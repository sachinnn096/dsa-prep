package BST;

public class ValidateBst {
}


/*

 */

/*

class Solution {
    public boolean isValidBST(TreeNode root) {

        return validateBst( root,Long.MIN_VALUE, Long.MAX_VALUE );
    }


    // function for validating is binary tree a valid binary search tree or not
    public boolean validateBst( TreeNode root,long min, long max ){
        // base case [ single node ]
        if( root == null ) return true;
        // core  condition
        if( root.val <= min || root.val >= max ) return false;

        // check for left & right subtree
        // if anyone not valid return false;

        return validateBst( root.left, min, root.val  ) && validateBst( root.right, root.val,max );

    }
}

 */