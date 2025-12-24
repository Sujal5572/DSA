class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // we can solve it by assuming it as a 1d sorted array for seraching in this we 
        // need to find the relation b/w the index of 1D array and 2D matrix
        // time complexity O(logm*n);
        int n = matrix.length;
        int m = matrix[0].length;
        int low =0;
        int high = m*n-1;
        while(low<=high){
            int mid = low + (high -low)/2;
            int row = mid / m; // for finding row
            int col = mid%m; // column
            int value = matrix[row][col];
            if(value == target)
            return true;
            if(value<target)
            low= mid+1;
            else
            high=mid-1;
        }
        return false;




        // o(n+m)
        // int i=0;
        // int j = matrix[0].length-1;
        // while(i<matrix.length && j>=0){
        //     if(matrix[i][j]==target)
        //     return true;
        //     else if(matrix[i][j]>target)
        //     j--;
        //     else
        //     i++;
        // }
        // return false;

        
    }
}