class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int ROWS = matrix.length;
         int COLS = matrix[0].length;

         int l = 0, r = ROWS*COLS-1;

         while(l <= r) {
            int m = l + (r-l)/2;
            int row = m/COLS;
            int col = m % COLS;
            int a = matrix[row][col];

            if(a < target) l = m+1;
            else if(a > target) r = m-1;
            else return true;
         }
         return false;
    }
}
