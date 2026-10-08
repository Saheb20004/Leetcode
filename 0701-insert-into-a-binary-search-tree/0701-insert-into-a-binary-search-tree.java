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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // base case
        if(root == null)    return new TreeNode(val);

        TreeNode curr = root;
        while(true){
            // If the node is greater equal to the current node then search for right subtree
            if(curr.val <= val){
                if(curr.right != null){
                    curr = curr.right;
                }
                else{ // NO right subtree
                    curr.right = new TreeNode(val); // then simply add to the curr right
                    break;
                }
            }

            // If the node is less than the current node then search for left subtree
            else{ 
                if(curr.left != null){
                    curr = curr.left;
                }
                else{ // NO left subtree
                    curr.left = new TreeNode(val); // then simply add to the curr left
                    break;
                }
            }
        }
        return root;
    }
}