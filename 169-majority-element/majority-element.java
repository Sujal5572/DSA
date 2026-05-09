class Solution {
    public int majorityElement(int[] nums) {

//         int count=0; // storing count of element
//         int ele=0; // element
//         for(int i :nums){
//             if(count==0){ // if count becomes zeros after cancelling out with different element
//             count =1;  // then we should initialized count with 1 and
//             ele= i; // then we ahould store that in ele.
//             }
//             else if(ele==i) // if ele is same then we shoyuld increment the counter;
//             count++;
//             else
//             count--; // if different ele encounter then we should decrease the count;
//         }


// return ele;


      // tc = O(N) as we are traversing the array once and sc of O(n) as we are using map
    Map<Integer,Integer> m = new HashMap<>();
    int n = nums.length;
        for(int num : nums){
            m.put(num,m.getOrDefault(num,0)+1);
            if(m.get(num)>n/2)
                return num;
        }
    return -1;

        //   int f[]= new int[n];
        // for(int i=0;i<n;i++){
        //     f[nums[i]]+=1;
        // }
        // int max= f[0];
        // int j=0;
        // for(int i=1;i<f.length;i++){
        //     if(max<f[i])
        //     {
        //         max= f[i];
        //         j=i;
        //     }
        // }
        // return j;
    }
}