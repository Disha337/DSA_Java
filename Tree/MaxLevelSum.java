//Leetcode 1161. Maximum Level Sum of a Binary Tree
//Approach : Breadth-First Search (BFS) / Level Order Traversal
//Time Complexity : O(n)
//Space Complexity : O(n)

/* We traverse the binary tree level by level using a queue and compute the
sum of node values at each level. While traversing, we track the maximum
sum encountered and the corresponding level number. Since levels are
processed from top to bottom, the smallest level with the maximum sum
is naturally selected.*/

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Returns the smallest level number that has the maximum sum of node values.
     */
    public int maxLevelSum(TreeNode root) {

        // Queue for level order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 1;              // Tracks current level number
        int maxLevel = 1;                  // Level with maximum sum
        int maxSum = Integer.MIN_VALUE;    // Maximum sum found so far

        // Perform BFS
        while (!queue.isEmpty()) {

            int levelSize = queue.size();  // Number of nodes at current level
            int levelSum = 0;              // Sum of values at current level

            // Process all nodes of the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                // Add left child to queue if it exists
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child to queue if it exists
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Update maximum sum and corresponding level
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            // Move to next level
            currentLevel++;
        }

        return maxLevel;
    }
}
