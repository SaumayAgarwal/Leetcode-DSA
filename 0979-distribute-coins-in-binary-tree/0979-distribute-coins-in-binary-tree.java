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
        int[] right=dfs(root.right);

        int balance=root.val+left[0]+right[0]-1;
        int ans=left[1]+right[1]+Math.abs(balance);

        return new int[]{balance, ans};
    }
    public int distributeCoins(TreeNode root) {
        return dfs(root)[1];
    }
}