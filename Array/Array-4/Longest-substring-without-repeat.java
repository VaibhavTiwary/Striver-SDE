class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;       
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max_len = -1; 
        
        while (j < s.length()) {
            char temp = s.charAt(j);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            
            while (map.size() < j - i + 1) {  
                char leftChar = s.charAt(i);
                if (map.get(leftChar) == 1) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, map.get(leftChar) - 1);
                }
                i++; 
            }
            
            if (map.size() == j - i + 1) {
                max_len = Math.max(max_len, j - i + 1);
                j++;
            }  
            
        }
        if(max_len > 0){
            return max_len;
        }
        return 0;
    }
}