class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        // Expected sum and sum of squares
        long sum = (long) n * (n + 1) / 2;
        long sumSq = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        // Actual sum and sum of squares from array
        long actualSum = 0;
        long actualSumSq = 0;
        for (int num : nums) {
            actualSum += num;
            actualSumSq += (long) num * num;
        }
        
        // Let R = repeating, M = missing
        long diff = actualSum - sum; // R - M
        long sqDiff = actualSumSq - sumSq; // R^2 - M^2
        
        // R + M = sqDiff / diff
        long sumRM = sqDiff / diff;
        
        int R = (int) ((diff + sumRM) / 2);
        int M = (int) (sumRM - R);
        
        return new int[]{R, M};
    }
}
