// You are given an array with unique elements of stalls[], which denote the positions of stalls. 
// You are also given an integer k which denotes the number of aggressive cows. The task is to assign stalls 
// to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples:

// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows in this case is 3, which is the largest among all possible ways.


/*
 * Problem: Aggressive Cows
 * -----------------------------------------
 * You are given an array 'stalls' of size 'n' (positions of stalls)
 * and an integer 'k' (number of cows). You need to place 'k' cows
 * in the stalls such that the **minimum distance** between any two cows
 * is as large as possible.
 * 
 * Approach:
 * - Sort the stall positions.
 * - Use Binary Search on the "minimum distance" between cows.
 * - For each mid (representing minimum distance), check if it’s
 *   possible to place all cows keeping at least that much distance apart.
 * - If possible, store it and try a larger distance; else try a smaller one.
 * 
 * Time Complexity: O(n * log(max_distance))
 * Space Complexity: O(1)
 */

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        
        int n = stalls.length;
        Arrays.sort(stalls);  // Sort the stall positions
        
        // Minimum possible distance = 1
        // Maximum possible distance = farthest stall difference
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = -1;
        
        // Binary Search on the possible minimum distance between cows
        while (high >= low) {
            // 'mid' represents the minimum distance we are testing
            int mid = low + (high - low) / 2;
            
            int cows = 1;             // First cow in the first stall
            int lastPos = stalls[0];  // Position of last placed cow
            
            // Try to place the remaining cows
            for (int i = 1; i < n; i++) {
                // If current stall is at least 'mid' distance from last placed cow
                if (stalls[i] - lastPos >= mid) {
                    cows++;                 // Place another cow
                    lastPos = stalls[i];    // Update last position
                }
                // Stop early if all cows are placed successfully
                if (cows == k) break;
            }
            
            // If all cows placed with at least 'mid' distance → try for larger gap
            if (cows >= k) {
                ans = mid;        // Store the valid minimum distance
                low = mid + 1;    // Try to increase the distance
            } 
            else {
                high = mid - 1;   // Decrease the distance
            }
        }
        
        // 'ans' holds the largest possible minimum distance between any two cows
        return ans;
    }
}

