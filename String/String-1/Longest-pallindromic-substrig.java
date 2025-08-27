// Given a string s, return the longest palindromic substring in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// The nested loops iterate over O(n^2) pairs, and for each pair, you call solve which checks memoized values in 
// O(1).

// Therefore, total time complexity = O(n^2).

//Memoization approach
class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];

        int maxLen = 1;
        int startPoint = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(solve(s, i, j, dp)){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        startPoint = i;
                    }
                }
            }
        }
        return s.substring(startPoint, startPoint + maxLen);

    }

    boolean solve(String str, int i, int j, Boolean[][] dp){

        if(i >= j){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(str.charAt(i) == str.charAt(j)){
            return dp[i][j] = solve(str, i+1, j-1, dp);
        }
        return dp[i][j] = false;

    }
}


//Expand From Centre Approach
class Solution {
    public String longestPalindrome(String s) {
        
        StringBuilder ans = new StringBuilder();
        int maxLen = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++){
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxLen){
                    ans.setLength(0);
                    ans.append(s.substring(l, r+1));
                    maxLen = r-l+1;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxLen){
                    ans.setLength(0);
                    ans.append(s.substring(l, r+1));
                    maxLen = r-l+1;
                }
                l--;
                r++;
            }

        }
        return ans.toString();
    }
}