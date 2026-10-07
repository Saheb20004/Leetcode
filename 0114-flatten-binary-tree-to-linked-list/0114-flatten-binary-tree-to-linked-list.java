/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Stack Based Approach

class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        // Base Case
        if(root == null)    return;

        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            st.pop();

            if(curr.right != null)
                st.push(curr.right);
            if(curr.left != null)
                st.push(curr.left);

            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
}