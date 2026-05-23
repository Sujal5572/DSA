class Solution {
    public int maxArea(int[] height) {


        // tc will be O(n)since we are traversing the array only once 
        int i =0;
        int j= height.length - 1;
        int maxArea =0;
        while(i<j){
            int width = j-i;
            int minHeight = Math.min(height[i],height[j]);
            int area = width*minHeight;
            maxArea = Math.max(area , maxArea);
            if(height[i]<height[j]){
                i++;
            }
            else
            j--;
        }
        return maxArea;
        
    }
}