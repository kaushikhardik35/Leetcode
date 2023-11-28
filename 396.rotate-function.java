/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int cur=0;
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            cur+=i*nums[i];
            sum+=nums[i];
        }
        int max=cur;
        int sum2=0;
         //System.out.println(cur);
        for(int i=0;i<n;i++){
            sum-=nums[i];
            cur-=sum;
            cur+=(n-1)*nums[i];
            //System.out.println(cur);
            max=Math.max(cur,max);
            sum+=nums[i];
        }
        return max;
    }
}
// @lc code=end

