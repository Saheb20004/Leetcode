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
    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // for finding Range
    private boolean checkValidBST(TreeNode root, long minVal, long maxVal){
        // Base Case
        if(root == null)    return true;
        // Violation Condition
        if(root.val >= maxVal || root.val <= minVal)    return false;

        return checkValidBST(root.left, minVal, root.val)
            && checkValidBST(root.right, root.val, maxVal);
    }
}