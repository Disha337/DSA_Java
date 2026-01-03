//Leetcode 1411 : Number of Ways to Paint N × 3 Grid
//Approach : (Recursion + Memoization : DP On Grids) 12-state DP
//Time Complexity : O(n)
//Space Complexity : O(n)

/*class Solution {
    int M = 1_000_000_007;
    int[][] t;

    // 12 possible row patterns
    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };

    int solve(int n, int prev) {
        if (n == 0)
            return 1;

        if (t[n][prev] != -1)
            return t[n][prev];

        int result = 0;
        String last = states[prev];

        for (int curr = 0; curr < 12; curr++) {
            if (curr == prev)
                continue;

            String currPat = states[curr];
            boolean conflict = false;

            for (int col = 0; col < 3; col++) {
                if (currPat.charAt(col) == last.charAt(col)) {
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                result = (result + solve(n - 1, curr)) % M;
            }
        }

        return t[n][prev] = result;
    }

    public int numOfWays(int n) {
        t = new int[n][12];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                t[i][j] = -1;
            }
        }

        int result = 0;

        // choose first row
        for (int i = 0; i < 12; i++) {
            result = (result + solve(n - 1, i)) % M;
        }

        return result;
    }
}*/

//Time Complexity : O(n)
//Space Complexity : O(1)
//Approach  : 2-state optimized DP
class Solution{
public int numOfWays(int n) {
    long MOD = 1_000_000_007;
    long same = 6, diff = 6;

    for (int i = 2; i <= n; i++) {
        long newSame = (same * 3 + diff * 2) % MOD;
        long newDiff = (same * 2 + diff * 2) % MOD;
        same = newSame;
        diff = newDiff;
    }

    return (int)((same + diff) % MOD);
}
}

