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
    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            // If left subtree exists
            if (curr.left != null) {

                // Find the rightmost node of left subtree
                TreeNode prev = curr.left;

                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect right subtree after left subtree
                prev.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;

                // Remove left child
                curr.left = null;
            }

            // Move to next node
            curr = curr.right;
        }
    }
}