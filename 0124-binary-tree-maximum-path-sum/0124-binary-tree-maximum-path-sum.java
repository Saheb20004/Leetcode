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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return max;
    }

    private int findMaxSum(TreeNode root){
        // Base Case
        if(root == null)    return 0;

        // Maximum contribution from left subtree
        int leftSum = Math.max(0, findMaxSum(root.left));
        // Maximum contribution from right subtree
        int rightSum = Math.max(0, findMaxSum(root.right));

        // Path passing through current node and Update global maximum
        max = Math.max(max, root.val + leftSum + rightSum);
        // Return one side to parent
        return root.val + Math.max(leftSum, rightSum);
    }
}