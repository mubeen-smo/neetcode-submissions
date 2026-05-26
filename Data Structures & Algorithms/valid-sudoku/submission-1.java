class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                // Optional input validation (safer than assuming only '1'..'9')
                if (c < '1' || c > '9') return false;

                int num = c - '1';               // 0..8
                int bit = 1 << num;              // mask for that digit
                int boxIndex = (i / 3) * 3 + (j / 3);

                if ((rows[i] & bit) != 0) return false;
                if ((cols[j] & bit) != 0) return false;
                if ((boxes[boxIndex] & bit) != 0) return false;

                rows[i] |= bit;
                cols[j] |= bit;
                boxes[boxIndex] |= bit;
            }
        }
        return true;
    }
}