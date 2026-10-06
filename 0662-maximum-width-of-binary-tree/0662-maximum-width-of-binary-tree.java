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

    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }


    public int widthOfBinaryTree(TreeNode root) {
        // Base Case
        if(root == null)    return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        int width = 0;

        // Apply Level Order Traversal
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            int idxF = 0;
            int idxL = 0;

            int minIdx = queue.peek().index; // Find min index of curr level
            int size = queue.size();
            for(int i=0; i < size; i++){
                Pair curr = queue.poll();

                int idx = curr.index-minIdx; //Re-Cal index to prevent overflow starting fr 0
                TreeNode node = curr.node;

                if(i == 0)  idxF = idx; // First node index of curr level
                if(i == size-1) idxL = idx; // Last node index of curr level

                if(node.left != null)
                    queue.add(new Pair(node.left, 2 * idx + 1)); // LC For 0-based indexing
                if(node.right != null)
                    queue.add(new Pair(node.right, 2* idx + 2)); // RC For 0-based indexing
            }
            width = Math.max(width, idxL - idxF + 1);
        }
        return width;
    }
}