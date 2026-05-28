class Solution {
    public int jump(int[] nums) {

                // greedy
        int currInd =0;
        int far =0;
        int jump =0;

        for(int i=0;i<nums.length-1;i++){
            far = Math.max(far , i + nums[i]);
            if(i == currInd){ // reached current jump boundary
                jump ++;
                currInd = far;
            }

        }
        return jump;
    }
}


//         int dp[]= new int[nums.length];
//         Arrays.fill(dp,-1);
//         return solve(nums ,0,dp);

//     }
//     public int solve(int nums[], int ind, int dp[]){
//         if(ind>= nums.length-1)return 0;
//         int miniJump = Integer.MAX_VALUE;
//         if(dp[ind]!=-1)return dp[ind];

//         for(int i=1;i<=nums[ind];i++){
//             int ans = solve(nums , i + ind,dp);
//             if(ans != Integer.MAX_VALUE){
//                 miniJump = Math.min(miniJump , 1 + ans);
//             }
//         }
//         return miniJump;
//     }
// }




