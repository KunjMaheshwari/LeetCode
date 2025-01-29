/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public static boolean symmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        //your code goes here
        if(root == null){
            return true;
        }

        return symmetric(root.left, root.right);
    }
}