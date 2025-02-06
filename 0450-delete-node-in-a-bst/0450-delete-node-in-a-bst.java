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
    // function to calculate the inorder successor
    public static TreeNode calculateInorderSuccessor(TreeNode root, int key){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            // Case 1 -> Leave Node
            if(root.right == null && root.left == null){
                return null;
            }

            // Case 2 -> One Node
            if(root.right == null){
                return root.left;
            }
            if(root.left == null){
                return root.right;
            }

            // Case 3 -> Two children
            TreeNode inorderSuccessor = calculateInorderSuccessor(root.right, key);
            root.val = inorderSuccessor.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
}