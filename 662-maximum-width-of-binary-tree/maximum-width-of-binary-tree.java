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
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node , int num){
            this.node =node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // tc will be O(n)as we are doing level order traversal
        // sc will be O(n) as we are using queue
        if(root == null)return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root ,0));
        int ans =0;
        while(!q.isEmpty()){
            int size = q.size();
            int minm = q.peek().num;
            int first =0 , last =0;
            for(int i=0;i<size;i++){
                int currI = q.peek().num - minm;
                TreeNode node = q.poll().node;
                if(i==0) first = currI;
                if(i == size -1) last = currI;
                if(node.left!= null)
                q.offer(new Pair(node.left , 2*currI + 1));
                if(node.right!= null)
                q.offer(new Pair(node.right , 2*currI + 2));
            }
            ans = Math.max(ans , last - first + 1);

        }
        return ans;
        
    }
}