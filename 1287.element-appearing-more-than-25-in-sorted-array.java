/*
 * @lc app=leetcode id=1287 lang=java
 *
 * [1287] Element Appearing More Than 25% In Sorted Array
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
      int n=arr.length;
      int prev=1;
      double max=n/4;
      for(int i=1;i<n;i++){
          if(arr[i]==arr[i-1]){
              prev++;
          }
          else{
              prev=1;
          }
          if(prev>max)
          return arr[i];
      }  
      return arr[n-1];
    }
}
// @lc code=end

