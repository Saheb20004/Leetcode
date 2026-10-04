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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode leftSubtree, TreeNode rightSubtree){
        // Edge Case
        if(leftSubtree == null || rightSubtree == null)
            return leftSubtree == rightSubtree;

        if(leftSubtree.val != rightSubtree.val)
            return false;

        
        return helper(leftSubtree.left, rightSubtree.right) &&
               helper(leftSubtree.right, rightSubtree.left) ;
    }
}