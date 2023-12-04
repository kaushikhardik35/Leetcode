/*
 * @lc app=leetcode id=1160 lang=java
 *
 * [1160] Find Words That Can Be Formed by Characters
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        int arr[]=new int[128];
        for(int i=0;i<chars.length();i++){
            arr[chars.charAt(i)]++; 
        }
        int ans=0;
        for(int i=0;i<words.length;i++){
            if (canBeFormed(words[i], arr)) {
                 ans+=words[i].length();
             }
             //System.out.println(ans);
        }

        return ans;
    }
    public boolean canBeFormed(String s,int arr[]){
        int arr2[]=new int[128];
        for(int i=0;i<s.length();i++){
            arr2[s.charAt(i)]++;
            if(arr2[s.charAt(i)]>arr[s.charAt(i)])
            return false;
        }
        return true;
    }
}
// @lc code=end

