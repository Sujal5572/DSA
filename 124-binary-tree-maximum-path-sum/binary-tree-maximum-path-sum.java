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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // here tc will be O(n)
        // sc (h)
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root){
        if(root == null)
        return 0;
        int leftgain = Math.max(0,dfs(root.left));
        int rightgain = Math.max(0,dfs(root.right));
        int currPathSum = root.val + leftgain + rightgain; // u shape sum
        maxSum = Math.max(maxSum , currPathSum);
        return root.val + Math.max(leftgain , rightgain);
    }

}







//         if(root == null)
//         return Integer.MIN_VALUE;
//         // tc will be O(n.n)as we are calculating height for every node
//         // sc will be O(h)recursion stack space  
//         //here we are going pick max from u shape || left || right
//         // max path sum through curr root
//         int through = root.val + Math.max(0,maxDownSum(root.left))+ Math.max(0,maxDownSum(root.right));// u shape
//         // check for left and right subtree
//         int leftMax = maxPathSum(root.left);
//         int rightMax = maxPathSum(root.right);
//         // we are going pick max from through and(left , right);
//         return Math.max(through , Math.max(leftMax,rightMax));


        
//     }
//     private int maxDownSum(TreeNode root){
//         if(root == null)
//         return 0;
//         int left = maxDownSum(root.left);
//         int right = maxDownSum(root.right);
//         return Math.max(0,root.val + left + right);
//     }
// }