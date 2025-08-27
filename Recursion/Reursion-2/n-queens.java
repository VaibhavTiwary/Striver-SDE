// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

// Example 1:


// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// TC- O(n * n^n)

class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, n);
        return ans;
    }

    void solve(int colIdx, char[][] board, int n) {
        if (colIdx == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            ans.add(solution);
            return;
        }

        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            if (check(rowIdx, colIdx, board, n)) {
                board[rowIdx][colIdx] = 'Q';

                solve(colIdx + 1, board, n);

                board[rowIdx][colIdx] = '.'; // Backtrack
            }
        }
    }

    boolean check(int rowIdx, int colIdx, char[][] board, int n) {
        // Check same row on the left
        for (int col = 0; col < colIdx; col++) {
            if (board[rowIdx][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        int i = rowIdx;
        int j = colIdx;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // Check lower-left diagonal
        i = rowIdx;
        j = colIdx;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        return true;
    }
}
