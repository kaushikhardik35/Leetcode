/*
 * @lc app=leetcode id=1561 lang=java
 *
 * [1561] Maximum Number of Coins You Can Get
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length/3;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=piles[n+(2*i)];
        }
        return ans;
    }
}
// @lc code=end

