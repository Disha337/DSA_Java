//Leetcode 1339. Maximum Product of Splitted Binary Tree
//Approach : DFS Tree Traversal
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    private static final int MOD = 1_000_000_007;
    private long maxProduct = 0;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        // First pass: compute total sum of the tree
        totalSum = getTotalSum(root);

        // Second pass: compute subtree sums and max product
        computeSubtreeSum(root);

        return (int) (maxProduct % MOD);
    }

    // DFS to compute total sum
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // DFS to compute subtree sums and update max product
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long subSum = node.val + leftSum + rightSum;

        // Product if we cut the edge above this subtree
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
