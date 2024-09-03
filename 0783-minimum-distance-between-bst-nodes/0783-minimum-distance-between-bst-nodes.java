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
    private Integer prev = null; // Stores the previous value in inorder traversal
    private int minDiff = Integer.MAX_VALUE; // Stores the minimum difference found

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    // Helper function to perform inorder traversal
    private void inorderTraversal(TreeNode root) {
        if (root == null) return; // Base case: if node is null, return

        // Traverse left subtree
        inorderTraversal(root.left);

        // Process the current node
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev); // Update minDiff if current difference is smaller
        }
        prev = root.val; // Update the previous value to the current node's value

        // Traverse right subtree
        inorderTraversal(root.right);
    }
}
