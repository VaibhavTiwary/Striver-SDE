// Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.

// To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.

// Return the following:

// If version1 < version2, return -1.
// If version1 > version2, return 1.
// Otherwise, return 0.
 

// Example 1:

// Input: version1 = "1.2", version2 = "1.10"

// Output: -1

// Explanation:

// version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.

class Solution {
    public int compareVersion(String version1, String version2) {
        
        int i = 0;
        int j = 0;
        int[] result1;
        int[] result2;

        while(i < version1.length() || j < version2.length()){
            result1 = helper(version1, i);
            result2 = helper(version2, j);
            int res1 = result1[0];
            int res2 = result2[0];
            i = result1[1];
            j = result2[1];

            if(res1 > res2) return 1;
            else if(res1 < res2) return -1;
        }
        return 0;
    }

    private int[] helper(String s, int idx){
        int num = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == '.') break;
            else num = num * 10 + (s.charAt(idx) - '0');
            idx++;
        }
        return new int[]{num, idx+1};
    }
}