package BinaryTree.Traversal;




//approach
// post order =  left right root
// pre order = root right left

// preorder with different variation
// preorder = root right left                  here the traversal will be first root,,,then right subtree,,, then left tree
// think of ds+approach...how can we acheive this ??

//if in stack you push left first then right --- means right is on top of stack acess(pop) it ....then again push its left child first then right ... so we can maintain the property [ root right left ]


/* code


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> postorder = new ArrayList<>();
        if( root == null ) return postorder;

        Deque<TreeNode> stack = new ArrayDeque<>();
        // algo push the root

        // pop the top of stack print it
        // push left child first
        // push right child

        stack.push( root );

        while( !stack.isEmpty() ){

            TreeNode curr = stack.pop();

            postorder.add( curr.val );
            // push left child/subtree
            if( curr.left != null ){
                stack.push( curr.left );
            }
            // push right child
            if( curr.right != null ){
                stack.push( curr.right );
            }
        }

        //revsersing the root right left  -> left right root = postorder
        // list contains root right left[ A different variation of preorder [root , righSubtree, leftSubtree ]]
        reverse(postorder);
        return postorder;
    }

    public void reverse( List<Integer> list ){
        int i = 0;
        int j = list.size()-1;

        while( i < j ){
            int temp = list.get(i);
            list.set(i, list.get(j) );
            list.set( j, temp );
            i++;j--;
        }
    }
}

 */