// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Time Complexity

// Number of states:
// index can be from 0 to n-1 → O(n) states

// Work per state:
// For each index, you try all end indices i = index .. n-1 → O(n) iterations

// Each substring creation: builder.toString() → O(k), k ≤ n

// Checking words.contains(...) → O(1)
// So work per state ≈ O(n) for iteration + O(n) for substring → O(n^2)

// 3 Total Complexity
// O(n ^ 3)

// dp[index] represents whether the substring s[index..] can be segmented using the dictionary.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, words, 0, dp);
    }

    boolean solve(String s, Set<String> words, int index, Boolean[] dp) {
        
        if(index == s.length()){
            return true;
        }

        if(dp[index] != null) return dp[index];

        for(int i = index; i < s.length(); i++){
            if(words.contains(s.substring(index, i+1))){
                if(solve(s, words, i + 1, dp)) return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}
