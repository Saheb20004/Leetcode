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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Map: Node -> Parent
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();

        // Create parent mapping
        markParents(root, parent_track);

        // Visited nodes
        Map<TreeNode, Boolean> visited = new HashMap<>();

        // BFS starting from target
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        visited.put(target, true);

        int curr_level = 0;

        // BFS until distance K
        while (!queue.isEmpty()) {

            int size = queue.size();

            // We have reached distance K
            if (curr_level == k) {
                break;
            }

            curr_level++;

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // 1. Go to LEFT child
                if (current.left != null && visited.get(current.left) == null) {

                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                // 2. Go to RIGHT child
                if (current.right != null && visited.get(current.right) == null) {

                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                // 3. Go to PARENT
                if (parent_track.get(current) != null &&
                    visited.get(parent_track.get(current)) == null) {

                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }

        // All nodes currently in queue are distance K
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }

        return result;
    }


    // Step 1: Store parent of every node
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            // Left child
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }

            // Right child
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
}