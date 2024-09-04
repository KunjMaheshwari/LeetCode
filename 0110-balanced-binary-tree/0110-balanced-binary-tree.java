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
    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSubtree = getHeight(root.left);
        int rightSubtree = getHeight(root.right);

        int max = Math.max(leftSubtree, rightSubtree)+1;
        return max;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftSubtree = getHeight(root.left);
        int rightSubtree = getHeight(root.right);

        if(Math.abs(leftSubtree - rightSubtree) <=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
}