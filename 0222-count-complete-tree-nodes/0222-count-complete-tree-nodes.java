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
    public int countNodes(TreeNode root) {
        // Base Case
        if(root == null)    return 0;

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right)     return (2 << left) - 1; // 2^height - 1

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    // Get height by going completely left, apply DFS
    private int getLeftHeight(TreeNode root){
        int count = 0;

        while(root.left != null){
            count ++;
            root = root.left;
        }
        return count;
    }

    // Get height by going completely right, apply DFS
    private int getRightHeight(TreeNode root){
        int count = 0;

        while(root.right != null){
            count ++;
            root = root.right;
        }
        return count;
    }
}