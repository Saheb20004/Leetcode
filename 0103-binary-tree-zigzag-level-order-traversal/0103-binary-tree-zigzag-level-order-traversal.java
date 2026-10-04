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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // Edge Case
        if(root == null)    return result;

        queue.add(root);
        boolean leftTOright = true; // flag

        // Traverse Level by Level
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null)   queue.add(node.left); // Add left child
                if(node.right != null)   queue.add(node.right); // Add right child
            }
            // Reverse Alternate Level
            if(!leftTOright)
                Collections.reverse(list);

            result.add(list);
            // Flag change for next level
            leftTOright = !leftTOright;
            
        } 
        return result;
    }
}