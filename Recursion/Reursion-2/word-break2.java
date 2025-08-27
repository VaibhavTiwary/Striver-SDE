// Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]

class Solution {
    ArrayList <String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList <String> temp = new ArrayList<>();
        Set <String> set = new HashSet<>();

        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        solve(s, 0, set, temp);
        return ans;
    }

    void solve(String s, int index, Set <String> set, ArrayList <String> temp){
        if(index == s.length()){
            // String sentence = "";
            // for(int j = 0; j < temp.size(); j++){
            //     sentence += temp.get(j);

            //     if(j != temp.size() - 1){
            //         sentence += " ";
            //     }
            // }
            // ans.add(sentence);

            ans.add(String.join(" ", temp));

            return;
        }

        StringBuilder res = new StringBuilder();
        for(int i = index; i < s.length(); i++){
            res.append(s.charAt(i));
            if(set.contains(res.toString())){
                temp.add(res.toString());
                solve(s, i + 1, set, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}


// In the worst case, every substring is a valid word, e.g., s = "aaaaa" and
//  wordDict = ["a","aa","aaa","aaaa","aaaaa"].

// The number of valid partitions grows exponentially, like the Catalan number: O(2^(n-1)) roughly

// At base case, String.join(" ", temp) → O(n) (copying current partition to ans)

// Let p = number of valid sentences (partitions).

// For each sentence, joining takes O(n)

// Worst-case TC:

// O(n⋅p)

//Memoization
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return solve(s, 0, set, memo);
    }

    private List<String> solve(String s, int index, Set<String> set, Map<Integer, List<String>> memo) {
        if (memo.containsKey(index)) return memo.get(index);

        List<String> res = new ArrayList<>();

        if (index == s.length()) {
            res.add(""); // base case: empty string
            return res;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (set.contains(word)) {
                List<String> next = solve(s, i, set, memo);
                for (String str : next) {
                    if (str.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + str);
                    }
                }
            }
        }

        memo.put(index, res);
        return res;
    }
}
// Time Complexity: O(n * p) (still exponential in output size)