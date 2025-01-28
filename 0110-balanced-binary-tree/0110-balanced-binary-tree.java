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
    public static int calculateHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftPart = calculateHeight(root.left);
        int rightPart = calculateHeight(root.right);

        return Math.max(leftPart, rightPart)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
}