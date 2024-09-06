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
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                sb.append("#,");
            }else{
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        // Use a StringBuilder to tokenize the serialized data
        StringBuilder s = new StringBuilder(data);
        String str;
        int commaIndex = s.indexOf(",");
        str = s.substring(0, commaIndex);
        s.delete(0, commaIndex + 1);
        // Read the root value from the serialized data
        TreeNode root = new TreeNode(Integer.parseInt(str));

        // Use a queue for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        // Start with the root node
        q.offer(root);

        // Perform level-order traversal to reconstruct the tree
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            // Read the value of the left child from the serialized data
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);
            if (!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                q.offer(leftNode);
            }

            // Read the value of the right child from the serialized data
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }

        // Return the reconstructed root of the tree
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));