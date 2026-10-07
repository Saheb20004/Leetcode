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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int m = postorder.length;
        int n = inorder.length;

        Map<Integer, Integer> inMap = new HashMap<>();
        // InOrder Mapping with its indexes
        for(int i = 0; i < inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = helper(postorder, 0, m-1, inorder, 0, n-1, inMap);
        return root;
    }


    private TreeNode helper(int[] postorder, int postStart, int postEnd,
                            int[] inorder, int inStart, int inEnd,
                            Map<Integer, Integer> inMap) 
    {
        // Base Case
        if(postStart > postEnd || inStart > inEnd)    return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        // Buid Left SubTree
        root.left = helper(postorder, postStart , postStart + numsLeft - 1,
                           inorder, inStart, inRoot - 1, inMap);

        // Build Right SubTree
        root.right = helper(postorder, postStart + numsLeft, postEnd - 1,
                           inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
    
}