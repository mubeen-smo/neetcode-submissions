class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; i++ ) {
            for(int j = 0; j < 9; j++ ) {
                if(board[i][j] == '.') continue; 
                int boxIndex = 3*(i/3) + j/3;
                int d = board[i][j] - '1';
                if(rows[i][d] || columns[j][d] || boxes[boxIndex][d]) {
                    return false;
                }
                rows[i][d] = true;
                columns[j][d] = true;
                boxes[boxIndex][d] = true;
            }
        }

        return true;

    }
}
