package BinaryTree.Traversal;


//inorder formula - left root right

//approach- go as left as possible (push)...
// now its time to backtrack  ,,, pop and print & if right subtree available then explore in same way
//  now curr = curr.right
// again repeat & go as left as possible


/*
class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        //base case
        if( root == null ) return inorder;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while( curr!=null || !stack.isEmpty() ){

            //going and pushing as left as possible
            while( curr != null ){
                stack.push( curr );
                curr = curr.left;
            }

            curr = stack.pop();
            inorder.add( curr.val );
            curr = curr.right;

        }

        return inorder;

    }
}
 */