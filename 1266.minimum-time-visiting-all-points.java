/*
 * @lc app=leetcode id=1266 lang=java
 *
 * [1266] Minimum Time Visiting All Points
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int dist=0;
        int n=points.length;
        for(int i=1;i<n;i++){
            int a=points[i-1][0];
            int b=points[i-1][1];
            int x=points[i][0];
            int y=points[i][1];
            dist += Math.max(Math.abs(a - x), Math.abs(b - y));

        }
        return dist;
    }
}
// @lc code=end

