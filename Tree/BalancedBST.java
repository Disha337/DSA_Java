//Leetcode 1382. Balance a Binary Search Tree
//Level : Medium
//Approach : 1)Extract values	: Inorder Traversal 
  //2)Build balanced tree	: Divide & Conquer 
  //3)Traversal type	: DFS 
  //4)Order	: Inorder (Left, Root, Right)
  //5)Strategy :	Rebuild tree
  //6)Technique	: Recursion
//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution{
  List<Integer> values = new ArrayList<>();
  public TreeNode balanceBST(TreeNode root){
    inorder(root);
    return buildBalancedBST(0,values.size()-1);
  }
  public void inorder(TreeNode node){
    if(node == null){
      return;
    }
    inorder(node.left);
    values.add(node.val);
    inorder(node.right);
  }
  private TreeNode buildBalancedBST(int start, int end){
    if(start > end){
      return null;
    }
    int mid = start + (end - start)/2;
    TreeNode root = new TreeNode(values.get(mid));
    root.left = buildBalancedBST(start, mid - 1);
    root.right = buildBalancedBST(mid + 1, end);
    return root;
  }
}

