// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
 

// Example 1:

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

//Recursion - TC=O(3 ^ max(n,m))
class Solution {
    public int minDistance(String word1, String word2) {
        
        return solve(0, 0, word1, word2);
    }

    int solve(int i, int j, String word1, String word2){

        //if first word ended then we will have to insert
        //ex- word1 = ab and word2 = abc
        // we need to insert word2.length() - 2 characters in word1
        if(i == word1.length()){
            return word2.length() - j;
        }

        if(j == word2.length()){
            return word1.length() - i;
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return solve(i+1, j+1, word1, word2);
        }

        int insert = 1 + solve(i, j+1, word1, word2);
        int delete = 1 + solve(i + 1, j, word1, word2);
        int replace = 1 + solve(i+1, j+1, word1, word2);

        return Math.min(insert, Math.min(delete, replace));


    }
}

//Memoization - O(n * m)
class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, word1, word2, dp);
    }

    int solve(int i, int j, String word1, String word2, int[][] dp){

        //if first word ended then we will have to insert
        //ex- word1 = ab and word2 = abc
        // we need to insert word2.length() - 2 characters in word1
        if(i == word1.length()){
            return word2.length() - j;
        }

        if(j == word2.length()){
            return word1.length() - i;
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return solve(i+1, j+1, word1, word2, dp);
        }

        if(dp[i][j] != -1) return dp[i][j];

        int insert = 1 + solve(i, j+1, word1, word2, dp);
        int delete = 1 + solve(i + 1, j, word1, word2, dp);
        int replace = 1 + solve(i+1, j+1, word1, word2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));


    }
}