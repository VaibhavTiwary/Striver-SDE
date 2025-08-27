class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;

        for(int num : set){
            if(!set.contains(num - 1)){

                int startnum = num;
                int length = 1;

                while(set.contains(startnum + 1)){
                    startnum++;
                    length++;
                }
                maxLen = Math.max(length, maxLen);
            }

        }
        return maxLen;
    }
}