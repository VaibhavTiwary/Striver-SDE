// Example 1:

// Input: s = "III"
// Output: 3
// Explanation: III = 3.
// Example 2:

// Input: s = "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.

class Solution {
    public int romanToInt(String s) {
  
   int sum = 0;
   for(int i = 0; i<s.length(); i++){
       int v = value(s.charAt(i));
       if(i+1 < s.length()){
         int r = value(s.charAt(i+1));
         if(v >= r){
           sum+=v;
         }else{
           sum-=v;
         }
       }else{
         sum+=v;
       }
    }
      return sum;
    }
     int value(char r){   
    if (r == 'I')   
      return 1;   
    if (r == 'V')   
      return 5;   
    if (r == 'X')   
      return 10;   
    if (r == 'L')   
      return 50;   
    if (r == 'C')   
      return 100;   
    if (r == 'D')   
      return 500;   
    if (r == 'M')   
      return 1000;   
    return -1;   
  }   
}