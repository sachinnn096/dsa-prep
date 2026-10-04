/*
approah
            formula root left right


*/


/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        //stack ds - to hold the nodes
        Deque<TreeNode> stack = new ArrayDeque<>();
        //store answer
        List<Integer> pre = new ArrayList<>();
        if( root == null ) return pre;

        TreeNode curr = root;

        while( curr != null || !stack.isEmpty() ){

            //going as left as possible
            while( curr != null ){
                pre.add( curr.val );
                stack.push( curr );
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;

        }

        return pre;

    }
}


 */