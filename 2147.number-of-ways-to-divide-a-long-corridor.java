/*
 * @lc app=leetcode id=2147 lang=java
 *
 * [2147] Number of Ways to Divide a Long Corridor
 */

// @lc code=start
class Solution {
    public int numberOfWays(String corridor) {
        int mod=1000000007;
        int n=corridor.length();
        int dp[]=new int[n+1];
        long ans=0;
        int cur=0;
        int i=0;
        while(cur!=2&&i<n){
            if(corridor.charAt(i)=='S'){
                cur++;
            }
            i++;
        }
        if(cur==2)
        ans=1;
        else{
            return 0;
        }
        int bet=0;
        cur=0;
        boolean flag=true;
        for(int j=i;j<n;j++){
            if(corridor.charAt(j)=='S'){
                cur++;
            }else{
                bet++;
            }
            if(cur==1&&flag){
                flag=false;
                ans*=(bet+1);
                ans=ans%mod;
                
            }
            if(cur==2){
                flag=true;
                bet=0;
                cur=0;
            }
            
        }
        if(cur==1)
        return 0;

        return (int)ans%mod;

    }
}
// @lc code=end

