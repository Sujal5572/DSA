class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;
        Arrays.sort(intervals ,(a,b)->a[1]-b[1]);// we are sorting according to end time
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prevEnd> intervals[i][0]){ // if any time we see prevEnd > curr start it means overlap
                count++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
        
    }
}