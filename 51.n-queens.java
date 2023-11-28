/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int board[][] = new int[n][n];
        solveNQueens(n, 0, board);
        return ans;
    }

    public void solveNQueens(int n, int i, int board[][]) {
        if (i == n) {
            boardToString(board);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isPossible(i, j, board)) {
                board[i][j] = 1;
                solveNQueens(n, i + 1, board);
                board[i][j] = 0;
            }
        }
    }
    public void boardToString(int board[][]){
        int n=board.length;
        List<String> s=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    sb.append("Q");
                }else{
                    sb.append('.');
                }
            }
            s.add(sb.toString());
        }
        ans.add(s);
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
