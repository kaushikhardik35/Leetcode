/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    int ans=0;
    public int totalNQueens(int n) {
        int board[][]=new int[n][n];
        solveNQueens(n,0,board);
        return ans;
    }
     public void solveNQueens(int n, int i, int board[][]) {
        if (i == n) {
            ans++;
        }
        for (int j = 0; j < n; j++) {
            if (isPossible(i, j, board)) {
                board[i][j] = 1;
                solveNQueens(n, i + 1, board);
                board[i][j] = 0;
            }
        }
    }
    public boolean isPossible(int i, int j, int board[][]) {
    for (int x = 0; x < board.length; x++) {
        if (board[x][j] == 1) {
            return false;
        }
    }

    // Check for the same column
    for (int x = 0; x < board.length; x++) {
        if (board[i][x] == 1) {
            return false;
        }
    }

    // Check for the upper-left diagonal
    for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
        if (board[x][y] == 1) {
            return false;
        }
    }

    // Check for the upper-right diagonal
    for (int x = i - 1, y = j + 1; x >= 0 && y < board.length; x--, y++) {
        if (board[x][y] == 1) {
            return false;
        }
    }

    // Check for the lower-left diagonal
    for (int x = i + 1, y = j - 1; x < board.length && y >= 0; x++, y--) {
        if (board[x][y] == 1) {
            return false;
        }
    }

    // Check for the lower-right diagonal
    for (int x = i + 1, y = j + 1; x < board.length && y < board.length; x++, y++) {
        if (board[x][y] == 1) {
            return false;
        }
    }

    return true; 
}
}
// @lc code=end

