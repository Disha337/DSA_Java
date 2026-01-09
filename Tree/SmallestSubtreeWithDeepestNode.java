//Leetcode LeetCode 865 – Smallest Subtree with all the Deepest Nodes
//Approach : Tree(DFS)(Post-order traversal)
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {

    // Helper class to store:
    // 1. the root of the smallest subtree containing all deepest nodes
    // 2. the maximum depth of the subtree
    private static class Result {
        TreeNode node;  // candidate subtree root
        int depth;      // maximum depth from this node downward

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // Main function required by LeetCode
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Perform DFS and return only the subtree root
        return dfs(root).node;
    }

    // Depth-first search function
    private Result dfs(TreeNode root) {

        // Base case:
        // If the node is null, depth is 0 and subtree root is null
        if (root == null) {
            return new Result(null, 0);
        }

        // Recursively process left and right subtrees
        Result left = dfs(root.left);
        Result right = dfs(root.right);

        // If left subtree is deeper,
        // then all deepest nodes are in the left subtree
        if (left.depth > right.depth) {
            return new Result(
                left.node,          // propagate left subtree root
                left.depth + 1      // increase depth by 1 for current node
            );
        }

        // If right subtree is deeper,
        // then all deepest nodes are in the right subtree
        if (right.depth > left.depth) {
            return new Result(
                right.node,         // propagate right subtree root
                right.depth + 1     // increase depth by 1
            );
        }

        // If both subtrees have the same depth,
        // then the deepest nodes are split between left and right,
        // so the current node is their Lowest Common Ancestor
        return new Result(
            root,                  // current node is the smallest subtree root
            left.depth + 1         // depth increases by 1
        );
    }
}
