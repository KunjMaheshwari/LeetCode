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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //your code goes here
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> arr = new ArrayList<>(Collections.nCopies(size, 0));

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                int index = leftToRight ? i : (size - 1 - i);
                arr.set(index, node.val);

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            leftToRight = !leftToRight;

            result.add(arr);
        }
        return result;
    }
}