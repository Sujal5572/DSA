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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root== null )return 0;
        int c =0;
        q.offer(root);
        while(!q.isEmpty()){
            c++;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }
        }
        return c;
    }
}

//         if(root == null)return 0;

//         q.offer(root);
//         int count = 0;
//         while(!q.isEmpty()){
//             count++;
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 if(q.peek().left!= null)q.offer(q.peek().left);
//                 if(q.peek().right!=null)q.offer(q.peek().right);
//                 q.poll();
//             }
            
//         }
//         return count;
//     }
// }