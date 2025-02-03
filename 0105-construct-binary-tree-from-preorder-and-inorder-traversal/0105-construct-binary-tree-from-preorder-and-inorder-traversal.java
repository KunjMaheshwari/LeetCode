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
    private int preIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length-1);
    }

    private TreeNode construct(int[] preorder, int left, int right){
        if(left > right) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]); // to get the value of root node from the preorder array.
        int idx = map.get(root.val);

        root.left = construct(preorder, left, idx-1);
        root.right = construct(preorder, idx+1, right);

        return root;
    }
}