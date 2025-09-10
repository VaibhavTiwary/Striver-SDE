// You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

// You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f
//  will break, and any egg dropped at or below floor f will not break.

// Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks,
//  you can no longer use it. However, if the egg does not break, you may reuse it in future moves.

// Return the minimum number of moves that you need to determine with certainty what the value of f is.


class Solution {
    HashMap<String, Integer> dp;

    public int superEggDrop(int k, int n) {
        dp = new HashMap<>();
        return solve(k, n);
    }

    private int solve(int eggs, int floors) {
        if (floors == 0 || floors == 1) return floors; 
        if (eggs == 1) return floors;

        String key = eggs + "_" + floors;
        if (dp.containsKey(key)) return dp.get(key);

        int minAttempts = Integer.MAX_VALUE;

        int low = 1, high = floors;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Two cases:
            int breakCase = solve(eggs - 1, mid - 1);  // Egg breaks, check below
            int noBreakCase = solve(eggs, floors - mid); // Egg survives, check above

            // Why floors - mid
            // Total floors = floors.
            // We already tested mid.
            // Remaining above floors = (floors - mid).
                        
            int worstCase = 1 + Math.max(breakCase, noBreakCase);
            // Since we don’t control the outcome (it depends on where the critical floor really is),we must prepare for the worst-case scenario among the two that's why taking max
            minAttempts = Math.min(minAttempts, worstCase);

            // Binary Search Optimization: Move towards the worst-case scenario
            if (breakCase > noBreakCase) {
                high = mid - 1;  // Move downward
            } else {
                low = mid + 1;   // Move upward
            }
        }

        dp.put(key, minAttempts);
        return minAttempts;
    }
}
