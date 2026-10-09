/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if(root == null)    return null;

        // If given two nodes are greater than root then search on right side
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        // If given two nodes are less than root then search on left side
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        return root;
    }
}