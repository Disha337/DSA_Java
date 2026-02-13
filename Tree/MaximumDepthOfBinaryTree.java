//Leetcode 104. Maximum Depth of Binary Tree
//Level : Easy
//Approach : Depth First Search (DFS)
// Order : Postorder (Left, Right, Root)
// Technique : Recursion
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
  public int maxDepth(TreeNode root){
    if(root == null){
      return 0;
    }

    int leftDepth = maxDepth(root.left);
    int rightDepth = masDepth(root.right);

    return 1 + Math.max(leftDepth, rightDepth);
  }
};
