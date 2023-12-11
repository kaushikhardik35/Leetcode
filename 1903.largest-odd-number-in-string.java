/*
 * @lc app=leetcode id=1903 lang=java
 *
 * [1903] Largest Odd Number in String
 */

// @lc code=start

class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        String ans="";
        for(int i=n-1;i>=0;i--){
            int t=num.charAt(i);
            if(t%2==1) {
                return num.substring(0, i+1);
            }
        }
        return ans;

    }
}
// @lc code=end

