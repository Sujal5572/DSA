class Solution {
    public List<Integer> majorityElement(int[] nums) { 
        // tc =O(n) and sc = O(1)
        int n = nums.length;
        int ele1 =0, ele2 =0;
        int count1=0, count2 =0;
        for(int i : nums){
            if(count1==0 && ele2!=i){ // as both ele2 and ele1 become same then only for one case it will increase the count
                ele1 =i;
                count1=1;
            }
            else if(count2 ==0 && ele1!=i){
                ele2 =i;
                count2 = 1;
            }
            else if(ele1==i){
                count1++;
            }
            else if(ele2==i){
                    count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 =0;
        count2=0;
        for(int i : nums){
            if(ele1 == i)count1++;
            else if(ele2 == i)count2++;
        }
        int max = n/3 +1;
        if(count1>= max) ans.add(ele1);
        if(count2>=max)ans.add(ele2);
        return ans;



        // here tc is O(2n) sc O(2n)
        // Map<Integer,Integer> m = new HashMap<>();
        // int n = nums.length;
        // for(int i : nums){
        //     m.put(i,m.getOrDefault(i,0)+1);
        // }
        // List<Integer> ans = new ArrayList<>();
        // for(int i : m.keySet()){
        //     if(m.get(i)>(n/3))
        //     ans.add(i);
        // }
        // return ans;
        
    }
}