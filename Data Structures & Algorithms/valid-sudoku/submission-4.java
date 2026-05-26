class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean rows[][] = new boolean[9][9];
        boolean cols[][] = new boolean[9][9];
        boolean boxes[][] = new boolean[9][9];

        for(int i = 0 ; i < 9 ; i++ ) {
            for(int j = 0; j < 9 ; j++) {
                char c = board[i][j];
                int boxIndex = (i/3)*3 + j/3;;
                if(c != '.') {
                    int n = board[i][j] - '1';
                    if(rows[i][n] || cols[j][n] || boxes[boxIndex][n]) return false;
                    rows[i][n] = cols[j][n] = boxes[boxIndex][n] = true;
                }
            }
        }

        return true;
    }
}
