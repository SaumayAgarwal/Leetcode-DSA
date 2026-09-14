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
    int cameras=0;
    public int dfs(TreeNode root){
        if(root==null)return 1;
        int leftState=dfs(root.left);
        int rightState=dfs(root.right);

        if(leftState==0 || rightState==0){
            cameras++;
            return 2;
        }
        if(leftState==2 || rightState==2)return 1;
        return 0;
    }
    public int minCameraCover(TreeNode root) {
        int i=dfs(root);
        if(i==0)return cameras+1;
        return cameras;
    }
}