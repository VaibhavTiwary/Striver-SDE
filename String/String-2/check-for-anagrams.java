// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        HashMap <Character, Integer> map = new HashMap<>();
        for(char ch : str1){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch : str2){
            if(!map.containsKey(ch)){
                return false;
            }else{
                map.put(ch, (map.get(ch)-1));
            }
        }

        for(int count : map.values()){
            if(count != 0){
                return false;
            }
        }
        return true;


    }
}