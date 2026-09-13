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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set=new HashSet<>();

        for(int i:to_delete)set.add(i);

        List<TreeNode> forest=new ArrayList<>();
        root=makeForest(root, forest, set);

        if(root!=null)forest.add(root);
        return forest;
    }

    public TreeNode makeForest(TreeNode root, List<TreeNode> forest, Set<Integer> set){
        if(root==null)return null;

        root.left=makeForest(root.left, forest, set);
        root.right=makeForest(root.right, forest, set);

        if(set.contains(root.val)){
            if(root.left!=null)forest.add(root.left);
            if(root.right!=null)forest.add(root.right);

            return null;
        }

        return root;

    }
}