/*
 * @lc app=leetcode id=1688 lang=java
 *
 * [1688] Count of Matches in Tournament
 */

// @lc code=start
class Solution {
    public int numberOfMatches(int n) {
        int ans=0;
        if(n==1)
        return 0;
        if(n%2==0){
            return n/2+numberOfMatches(n/2);
        }
        return n/2+numberOfMatches(n/2+1);
    }
}
// @lc code=end

