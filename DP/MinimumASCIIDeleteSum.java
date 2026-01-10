//Leetcode 712. Minimum ASCII Delete Sum for Two Strings
//Approach : DP
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

public class MinimumASCIIDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {

        // Lengths of both strings
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] represents the minimum ASCII delete sum
        // to make s1[0..i-1] and s2[0..j-1] equal
        int[][] dp = new int[m + 1][n + 1];

        // Base case:
        // If s2 is empty, we must delete all characters from s1
        for (int i = 1; i <= m; i++) {
            // Add ASCII value of current character from s1
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // Base case:
        // If s1 is empty, we must delete all characters from s2
        for (int j = 1; j <= n; j++) {
            // Add ASCII value of current character from s2
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If current characters are equal,
                // no deletion is needed for these characters
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // If characters are different,
                // we have two choices:
                // 1. Delete character from s1
                // 2. Delete character from s2
                else {
                    dp[i][j] = Math.min(
                        // Delete s1[i-1]
                        dp[i - 1][j] + s1.charAt(i - 1),

                        // Delete s2[j-1]
                        dp[i][j - 1] + s2.charAt(j - 1)
                    );
                }
            }
        }

        // The bottom-right cell contains the answer
        return dp[m][n];
    }
}
