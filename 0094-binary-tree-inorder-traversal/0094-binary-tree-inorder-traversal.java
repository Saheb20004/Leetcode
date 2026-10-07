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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;
        while(curr != null){
            // Case 1: No left subtree, Visit current node and move to the right
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }
            // Case 2: Left subtree exists
            else{
                // Find the inorder predecessor of curr = rightmost node in curr's left subtree
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                // First time visiting curr
                if(prev.right == null){
                    prev.right = curr; // Create a temporary thread from predecessor to curr
                    curr = curr.left; // Move to the left subtree
                }
                // Second time reaching curr
                else{
                    prev.right = null; // Remove the temporary thread
                    list.add(curr.val); // Now visit curr
                    curr = curr.right; // Move to the right subtree
                }
            }
        }
        return list;
    }
}