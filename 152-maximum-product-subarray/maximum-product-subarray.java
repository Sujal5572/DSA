class Solution {
    public int maxProduct(int[] nums) {
        // O(n)
        int n = nums.length;
        int prefix =1;
        int suffix=1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix ==0 )prefix=1; // if we encounter 0
            if(suffix ==0)suffix =1;
            prefix *= nums[i];
            suffix *= nums[n-1-i];
            max = Math.max(max , Math.max(prefix,suffix));

        }
        return max;
    }
}
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             int prod =1;
//             for(int j=i;j<n;j++){
//                 prod *=nums[j];
//                 max = Math.max(prod,max);
//             }
//         }
//         return max;
//     }
// }


//         int ans = nums[0];
//         int max= nums[0];
//         int min = nums[0];
//         for(int i=1;i<n;i++){
//             if(nums[i]<0)
//             {
//                 int temp = max;
//                 max = min;
//                 min = temp;
//             }
//             max = Math.max(nums[i],nums[i]*max);
//             min = Math.min(nums[i],nums[i]*min);
//             ans = Math.max(ans , max);
//         }
//         return ans;
       
//     }
// }