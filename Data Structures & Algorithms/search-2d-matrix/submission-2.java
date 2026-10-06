class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int columns = matrix[0].length;

        int size = rows*columns;

        int l = 0, r = size-1;

        while(l <= r) {
            int m = l + (r - l)/2;
            int row = m/columns;
            int col = m % columns;

            int a = matrix[row][col];

            if(a < target) {
                l = m + 1;
            } else if(a > target) {
                r = m - 1;
            } else return true;

        }

        return false;

    }
}
