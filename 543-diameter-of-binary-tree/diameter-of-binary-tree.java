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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
        
    }
    private int height(TreeNode root){
        if(root == null)
        return 0;
        int left = height(root.left);
        int right = height(root.right);
        dia = Math.max(dia , (left + right));
        return 1 + Math.max(left ,right);
    }
}

    // by calculating height for each node O(n^2)
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null)return 0;
//         int left = height(root.left);
//         int right = height(root.right);
//         int final_Dia = left + right;

//         int dia_left = diameterOfBinaryTree(root.left);
//         int dia_right = diameterOfBinaryTree(root.right);
//         return Math.max(final_Dia , Math.max(dia_left , dia_right));
//     }
//     public int height(TreeNode root){
//         if(root == null)return 0;
//         return 1 + Math.max(height(root.left),height(root.right));
//     }
// }