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
    public static void solve(TreeNode root, int n){
        if(n < root.val){
            if(root.left == null){
                root.left = new TreeNode(n);
            }else{
                solve(root.left, n);
            }
        }

        if(n > root.val){
            if(root.right == null){
                root.right = new TreeNode(n);
            }else{
                solve(root.right, n);
            }
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++){
            solve(root, preorder[i]);
        }
        return root;
    }
}