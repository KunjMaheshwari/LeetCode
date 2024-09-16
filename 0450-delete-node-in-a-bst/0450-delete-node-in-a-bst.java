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
    public static TreeNode findInorderSubtree(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);  // Search in the right subtree
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);    // Search in the left subtree
        } else {
            // Node with the key found, now handle its deletion

            // Case 1: Leaf node (no children)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node with only one child
            if (root.left == null) {
                return root.right;  // Return the right child
            }
            if (root.right == null) {
                return root.left;   // Return the left child
            }

            // Case 3: Node with two children
            TreeNode inorderSuccessor = findInorderSubtree(root.right);

            // Replace the node's value with the inorder successor's value
            root.val = inorderSuccessor.val;

            // Delete the inorder successor from the right subtree
            root.right = deleteNode(root.right, inorderSuccessor.val);
        }

        return root;  // Return the root after deletion
    }
}
