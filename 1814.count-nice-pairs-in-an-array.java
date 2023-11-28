/*
 * @lc app=leetcode id=1814 lang=java
 *
 * [1814] Count Nice Pairs in an Array
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int countNicePairs(int[] nums) {
        int mod=1000000007;
        int n=nums.length;
        int arr[]=new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=getSelfDiff(nums[i]);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        long cur=1;
        long ans=0;
        //System.out.println(map);
        for(int t :map.keySet()){
             cur=map.get(t);
             ans = (ans%mod + (cur*(cur-1))/2)%mod;
             ans=ans%mod;
        }
        return (int)ans;
    }
    public int getSelfDiff(int num){
        int t=0;
        int temp=num;
        while(temp!=0){
            t*=10;
            t+=temp%10;
            temp=temp/10;
        }
        return num-t;
    }
}
// @lc code=end

