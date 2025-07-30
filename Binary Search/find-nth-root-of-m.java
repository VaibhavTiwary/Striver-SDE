// You are given 2 numbers n and m, the task is to find n√m (nth root of m). 
// If the root is not integer then returns -1.

// Examples :

// Input: n = 3, m = 27
// Output: 3
// Explanation: 33 = 27

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = (m/n) + 1;
        while(high >= low){
            int mid = low + (high - low)/2;
            
            int prod = 1;
            for(int i = 0; i < n; i++){
                prod = prod * mid;
                if(prod > m) break;
            }
            if(prod == m) return mid;
            
            else if(prod < m){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}