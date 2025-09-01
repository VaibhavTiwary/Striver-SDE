// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

 

// Example 1:

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

//Recursive
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        return solve(length1, length2, text1, text2);
    }

    int solve(int length1, int length2, String text1, String text2){
        if(length1 == 0 || length2 == 0){
            return 0;
        }

        int pick = 0;
        int notPick = 0;
        if(text1.charAt(length1 - 1) == text2.charAt(length2 - 1)){
            return 1 + solve(length1 - 1, length2 - 1, text1, text2);
        }

        
        return Math.max(solve(length1 - 1, length2, text1, text2) , solve(length1, length2 - 1, text1, text2));
    
    }
}

//Memoization - O(n * m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // dp[i][j] = LCS length for first i chars of text1 and first j chars of text2
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, m, text1, text2, dp);
    }

    private int solve(int i, int j, String text1, String text2, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            dp[i][j] = 1 + solve(i - 1, j - 1, text1, text2, dp);
        } else {
            dp[i][j] = Math.max(
                solve(i - 1, j, text1, text2, dp),
                solve(i, j - 1, text1, text2, dp)
            );
        }

        return dp[i][j];
    }
}

//Bottom - up

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];
        

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[length1][length2];
        
    }

    
}
