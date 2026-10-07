/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Base Case
        if(root == null)    return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Apply Level Order BFS Traversal
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr == null){
                result.append("null,");
                continue;
            }

            result.append(curr.val).append(",");

            // Add current node's children
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return result.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Base Case
        if(data == null || data.isEmpty())     return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String values[] = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // Apply Level Order BFS Traversal
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length){
            TreeNode parent = queue.poll();

            // For connecting Left Child
            if( !values[i].equals("null") ){
                TreeNode left = new TreeNode( Integer.parseInt(values[i]) );
                parent.left = left;
                queue.offer(left);
            }
            i++;

            // For connecting Right Child
            if( i < values.length && !values[i].equals("null") ){
                TreeNode right = new TreeNode( Integer.parseInt(values[i]) );
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));