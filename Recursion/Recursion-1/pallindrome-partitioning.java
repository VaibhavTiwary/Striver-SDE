// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]


class Solution {
    public List<List<String>> partition(String s) {

        List<String> partitions = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        Boolean[][] dp = new Boolean[s.length()][s.length()];
        solve(ans, partitions, s, 0, dp);
        return ans;
    }

    void solve(List<List<String>> ans, List<String> partitions, String s, int start, Boolean[][] dp){
        if(start == s.length()){
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i, dp)){
                partitions.add(s.substring(start, i+1));
                solve(ans, partitions, s, i+1, dp);
                partitions.remove(partitions.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j, Boolean[][] dp) {
        if (i >= j) return true;
        if (dp[i][j] != null) return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
        }
        return dp[i][j] = false;
    }
}