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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
       return new TreeNode(val);
       TreeNode cur = root;
       while(true){

        if(cur.val > val){ // addition will be in the left tree
        if(cur.left != null)cur = cur.left; // if left part is not null we are going to traverse till the end
        else{
            cur.left = new TreeNode(val); // if we found null for any node then we are going to add there val
            break;
        }

        }
        else{ // if val> root.right then same search
                if(cur.right != null )cur = cur.right;
                else{
                    cur.right = new TreeNode(val);
                    break;
                }
        }
       }
       return root;
        
    }
}