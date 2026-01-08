//Leetcode 1458. Max Dot Product of Two Subsequences
//Approach : DP(2D bottom-up DP)
//Time Complexity : O(n*m)
//Space COmplexity : O(n*m)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // dp[i][j] represents the maximum dot product
        // using nums1[0..i-1] and nums2[0..j-1]
        // with at least one pair chosen
        int[][] dp = new int[n + 1][m + 1];

        // Since dot product can be negative,
        // we initialize DP with a very small value
        int NEG_INF = Integer.MIN_VALUE / 2;

        // Initialize the DP table with NEG_INF
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = NEG_INF;
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Dot product of current elements
                int product = nums1[i - 1] * nums2[j - 1];

                // Four choices:
                // 1. Start a new subsequence with current pair
                // 2. Extend previous subsequence
                // 3. Skip current element from nums1
                // 4. Skip current element from nums2
                dp[i][j] = Math.max(
                        product,
                        Math.max(
                                dp[i - 1][j - 1] + product,
                                Math.max(dp[i - 1][j], dp[i][j - 1])
                        )
                );
            }
        }

        // The answer is the maximum dot product
        // using all elements from both arrays
        return dp[n][m];
    }
}
