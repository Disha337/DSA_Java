//Leetcode 110 : Balanced Binary Tree
//Level : Easy
//Approach : 1)Traversal - Depth First Search 2)Order -	Postorder (Left, Right, Root) 3)Strategy - Bottom-Up 4)Technique - Recursion 5)Optimization - Early exit using -1
//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution{
  public boolean isBalanced(TreeNode root){
    return Height(root) != -1;
  }
  private int Height(TreeNode node){
    if(node == null){
      return 0;
    }
    int leftHeight = Height(node.left);
    if(leftHeight == -1){
      return -1;
    }
    int rightHeight = Height(node.right);
    if(rightHeight == -1){
      return -1;
    }
    if(Math.abs(leftHeight - rightHeight) > 1){
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
};
