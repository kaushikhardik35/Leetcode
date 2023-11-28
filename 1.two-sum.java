/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                int arr[]=new int[2];
                arr[0]=map.get(target-nums[i]);
                arr[1]=i;
                return arr;
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end

