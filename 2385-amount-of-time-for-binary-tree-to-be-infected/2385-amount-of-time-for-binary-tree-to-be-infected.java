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

    public int amountOfTime(TreeNode root, int start) {

        // Map: Node -> Parent
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();

        // Create parent mapping
        markParents(root, parentTrack);

        // Find the start node
        TreeNode startNode = findStart(root, start);

        // Visited map
        Map<TreeNode, Boolean> visited = new HashMap<>();

        // BFS from target
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(startNode);
        visited.put(startNode, true);

        int time = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            boolean burnedNewNode = false;

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                // Go to LEFT
                if (curr.left != null &&
                    visited.get(curr.left) == null) {

                    queue.offer(curr.left);
                    visited.put(curr.left, true);

                    burnedNewNode = true;
                }

                // Go to RIGHT
                if (curr.right != null &&
                    visited.get(curr.right) == null) {

                    queue.offer(curr.right);
                    visited.put(curr.right, true);

                    burnedNewNode = true;
                }

                // Go to PARENT
                TreeNode parent = parentTrack.get(curr);

                if (parent != null &&
                    visited.get(parent) == null) {

                    queue.offer(parent);
                    visited.put(parent, true);

                    burnedNewNode = true;
                }
            }

            // If at least one new node burned,
            // one unit of time has passed.
            if (burnedNewNode) {
                time++;
            }
        }

        return time;
    }


    // Step 1: Create parent mapping
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

           TreeNode curr = queue.poll();

            // Left child
            if (curr.left != null) {
                parentTrack.put(curr.left, curr);
                queue.offer(curr.left);
            }

            // Right child
            if (curr.right != null) {
                parentTrack.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }

    // Find start node
    private TreeNode findStart(TreeNode root, int start) {

        if (root == null) {
            return null;
        }

        if (root.val == start) {
            return root;
        }

        TreeNode left = findStart(root.left, start);
        if (left != null) {
            return left;
        }

        TreeNode right = findStart(root.right, start);
        return right;

    }
}