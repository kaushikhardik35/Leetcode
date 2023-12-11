/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int findparent(int a,int arr[]){
        if(arr[a]==a)
        return a;
        arr[a]=findparent(arr[a], arr);
        return arr[a];

    }
    public int[] findRedundantConnection(int[][] edges) {
        int arr[]=new int[1001];
        int rank[]=new int[1001];
        for(int i=0;i<1001;i++){
            arr[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<edges.length;i++){
            int x1=findparent(edges[i][0], arr);
            int x2=findparent(edges[i][1], arr);
            if(x1==x2)
            return new int[]{edges[i][0],edges[i][1]};
            else{
                arr[x1]=arr[x2];
                if(rank[x1]>rank[x2]){
                    arr[x2]=arr[x2];
                }else if(rank[x2]>rank[x1]){
                    arr[x1]=arr[x2];
                }else{
                    arr[x1]=arr[x2];
                    rank[x2]++;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end

