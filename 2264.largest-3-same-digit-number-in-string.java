/*
 * @lc app=leetcode id=2264 lang=java
 *
 * [2264] Largest 3-Same-Digit Number in String
 */

// @lc code=start
class Solution {
    public String comp(String a ,String b){
       // System.out.println(a+" "+b);
        if(a.equals("")){
            return b;
        }
        if(b.equals(""))
        return a;
        return a.charAt(0)>b.charAt(0)?a:b;
    }
    public String largestGoodInteger(String nums) {
        String ans="";
        if(nums.length()<3){
            return "";
        }
        for(int i=0;i<=nums.length()-3;i++){
            if(nums.charAt(i)==nums.charAt(i+1)&&nums.charAt(i)==nums.charAt(i+2)){
                ans=comp(ans,nums.substring(i,i+3));
            }
        }
        return ans;
    }
}
// @lc code=end

