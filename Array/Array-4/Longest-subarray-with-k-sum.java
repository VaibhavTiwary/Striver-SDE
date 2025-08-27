// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest
//  subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum 
//  equal to k, return 0.

// Examples:

// Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
// Output: 6
// Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.





class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int rem = 0;
        int maxVal = 0;
        
        for(int i = 0; i < N; i++){
            sum += A[i];
            
            if (sum == K){
                maxVal = Math.max(maxVal, i+1);
            }
            
            rem = sum - K;
            
            if(map.containsKey(rem)){
                int temp = i - map.get(rem);
                maxVal = Math.max(maxVal, temp);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        
        return maxVal;
    }
}

// 0 sum
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap <Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(sum == 0){
                max_len = i+1;
            }
            if(map.containsKey(sum)){
                max_len = Math.max(max_len, i- map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return max_len;
        
    }
}


