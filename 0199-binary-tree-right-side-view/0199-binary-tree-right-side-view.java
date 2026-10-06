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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return helper(root, 0, list);
    }

    private List<Integer> helper(TreeNode node, int level, List<Integer> list){         
        // Base Case
        if(node == null)    return list;

         // First node encountered at current level
        if(level == list.size()){
            list.add(node.val);
        }

        helper(node.right, level+1, list); // Add Right Child First
        helper(node.left, level+1, list); // Then Add Left Child

        return list;
    }
}