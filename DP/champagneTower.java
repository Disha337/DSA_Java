// Leetcode 799. Champagne Tower
//Level : Medium
//Technique Used : 1D Dynamic Programming
//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution{
  public double champagneTower(int poured, int query_row, int query_glass){
    double[] dp = new double[101];
    dp[0] = poured;

    for(int row = 0; row<query_row; row++){
      double[] next = new double[101];

      for(int col = 0; col<= row; col++){
        if(dp[col] > 1){
          double overflow = (dp[col] - 1)/2.0;
          next[col] += overflow;
          next[col + 1] += overflow;
        }
      }
    dp = next;
    }
return Math.min(1.0, dp[query_glass]);
  }
}
