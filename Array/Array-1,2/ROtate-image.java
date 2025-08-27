// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                swap(i, j, matrix);
            }
        }

        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }


    }

    public void swap(int row, int col, int[][] matrix){
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }

    public void reverse(int[] mat){
        int left = 0;
        int right = mat.length - 1;
        while(right > left){
            int temp = mat[right];
            mat[right] = mat[left];
            mat[left] = temp;
            left++;
            right--;
        }
    }



}