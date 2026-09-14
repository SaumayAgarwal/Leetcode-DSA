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
    public int[] dfs(TreeNode root){
        if(root==null)return new int[]{0, 0};

        int[] left=dfs(root.left);
        int[]  right=dfs(root.right);

        int val=0;

        if(root.val+left[1]+right[1]>right[0]+left[0]){
            val=root.val+left[1]+right[1];
        }
        else{
            val=right[0]+left[0];
        }

        return new int[]{val, left[0]+right[0]};
    }
    public int rob(TreeNode root) {
        return dfs(root)[0];
    }
}