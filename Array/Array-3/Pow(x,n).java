// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000

class Solution {
    public double myPow(double x, int n) {

        long pow = n;
        return solve(x, pow);
    }

    double solve(double x, long pow){

        if(pow == 0) return 1;

        if(pow < 0){
            x = 1/x;
            pow = -1 * pow;
        }

        double half = solve(x, pow/2);
        if(pow % 2 == 0) return half * half;
        return half * half * x;
    }
}