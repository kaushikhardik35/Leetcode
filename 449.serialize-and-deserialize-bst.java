/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String[] arr;int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        return "-1";
        StringBuilder s=new StringBuilder();
        s.append(root.val);
        s.append(" ");
        s.append(serialize(root.left));
        s.append(" ");
        s.append(serialize(root.right));
        return s.toString();

    }
    public TreeNode deserialize(String data) {
        arr=data.split(" ");
        index=0;
        return go();
    }
    private TreeNode go() {
        int index=this.index++;
        if(arr[index].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[index]));
        root.left=go();
        root.right=go();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end

