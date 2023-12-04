/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr2[0], arr1[0]));
        HashMap<Integer,Integer> map=new HashMap<>();
        findFrequentTreeSum(root,map,pq);
        int max=pq.peek()[0];
        ArrayList<Integer>  al= new ArrayList<>();
        while(!pq.isEmpty()&&pq.peek()[0]>=max){
            int a[]=pq.poll();
            al.add(a[1]);
        }

        int[] ret = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ret[i] = al.get(i);
        }
        return ret;
        
    }
    public int findFrequentTreeSum(TreeNode root,HashMap<Integer,Integer> map,PriorityQueue<int[]> priorityQueue) {
        if(root==null){
            return 0;
        }
        int s1=findFrequentTreeSum(root.left,map,priorityQueue);
        int s2=findFrequentTreeSum(root.right,map,priorityQueue);
        int sum = root.val + s1 + s2;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        //System.out.println(sum+" "+map.get(sum));
        priorityQueue.add(new int[]{map.get(sum), sum});
        return root.val+s1+s2;
    }
}
// @lc code=end

