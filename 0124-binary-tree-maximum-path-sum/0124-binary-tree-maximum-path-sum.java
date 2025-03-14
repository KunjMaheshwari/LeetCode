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
    public static int findMaxPath(TreeNode root, int maxi[]){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(0, findMaxPath(root.left, maxi));
        int rightMax = Math.max(0, findMaxPath(root.right, maxi));

        maxi[0] = Math.max(leftMax + rightMax + root.val, maxi[0]);

        return Math.max(leftMax, rightMax) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int maxi[] = {Integer.MIN_VALUE};

        findMaxPath(root, maxi);

        return maxi[0];
    }
}