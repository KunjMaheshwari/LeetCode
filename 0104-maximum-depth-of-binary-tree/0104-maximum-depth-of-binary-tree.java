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
    public int maxDepth(TreeNode root) {
        // base condition 
        if(root == null){
            return 0;
        }

        // kaam
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1; //we have to add root as well.
    }
}