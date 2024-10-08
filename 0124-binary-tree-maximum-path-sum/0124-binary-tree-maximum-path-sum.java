/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public static int findMaxPathSum(TreeNode root, int maxi[]){
        if(root == null){
            return 0;
        }

        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.val);

        return Math.max(leftMaxPath, rightMaxPath) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        //your code goes here 
        int maxi[] = {Integer.MIN_VALUE};

        findMaxPathSum(root, maxi);

        return maxi[0];
    }
}