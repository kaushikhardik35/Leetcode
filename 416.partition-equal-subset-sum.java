/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    Map<String,Boolean> map;
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1)
        return false;
        map=new HashMap<>();
        return canPartition(nums,0,0,sum/2);
    }
    public boolean canPartition(int[] nums,Integer i,int cur,Integer sum) {
        if(sum==0)
        return true;
        String t =sum.toString() + " "+i.toString();
        if(map.containsKey(t)){
            return map.get(t);
        }
        if(i==nums.length)
        return false;
        boolean b= canPartition(nums,i+1,cur,sum)||canPartition(nums, i+1, cur+nums[i], sum-nums[i]);
        
        map.put(t,b);
        return b;
    }
}
// @lc code=end

