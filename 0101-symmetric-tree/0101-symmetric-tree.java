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
    public boolean isSymmetric(TreeNode root) {
       return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode p, TreeNode q) {
          if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if( p.val != q.val )  return false;

        boolean v1 = symmetric( p.left,  q.right);
        boolean v2 = symmetric( p.right,  q.left);

        return v1 && v2;
 
    }
}