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
    public static void rightView(TreeNode root, int level, List<Integer> arr){
        // base condition 
        if(root == null){
            return;
        }

        if(arr.size() == level){
            arr.add(root.val);
        }

        // right side
        rightView(root.right, level+1, arr);
        rightView(root.left, level+1, arr);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        rightView(root, 0, arr);

        return arr;
    }
}