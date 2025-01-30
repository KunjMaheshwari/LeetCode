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
    public static void dfs(TreeNode root, String path, List<String> arr){
        if(root == null){
            return;
        }

        path += root.val;
        if(root.left == null && root.right == null){
            arr.add(path);
        }

        path += "->";

        dfs(root.left, path, arr);
        dfs(root.right, path, arr);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr = new ArrayList<>();

        if(root == null){
            return arr;
        }

        dfs(root, "", arr);
        return arr;
    }
}