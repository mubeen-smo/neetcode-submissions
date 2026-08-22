class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (checkNext(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkNext(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = checkNext(board, i + 1, j, word, index + 1) ||
                        checkNext(board, i - 1, j, word, index + 1) ||
                        checkNext(board, i, j + 1, word, index + 1) ||
                        checkNext(board, i, j - 1, word, index + 1);

        board[i][j] = temp;

        return found;
    }
}
