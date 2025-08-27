// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.


class Solution {
    public void solveSudoku(char[][] board) {
        helper(0, 0, board);
    }

    boolean canPlaceNumber(char num, int r, int c, char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[r][i] == num){
                return false;
            }
        }

        for(int j = 0; j < 9; j++){
            if(board[j][c] == num){
                return false;
            }
        }

        int subGridStartRow = (r/3)*3;
        int subGridStartCol = (c/3)*3;
        for(int i = subGridStartRow ; i < subGridStartRow + 3; i++){
            for(int j = subGridStartCol; j < subGridStartCol + 3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    boolean helper(int row, int col, char[][] board){
        if(row == 9){
            return true;
        }
        
        if(col == 9){
            return helper(row + 1, 0, board);
        }

        if(board[row][col] != '.'){
            return helper(row, col + 1, board);
        }

        for(char num = '1'; num <= '9'; num++){
            if(canPlaceNumber(num, row, col, board)){
                board[row][col] = num;
                boolean res = helper(row, col+1, board);
                if(res == true) return true;
            }
        }
        board[row][col] = '.';
        return false;
    }
}