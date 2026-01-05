//Leetcode 1975. Maximum Matrix Sum
//Approach : Greedy + parity observation
//Time Complexity	O(n²)
//Space Complexity	O(1)

class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long sum = 0;                 // Stores sum of absolute values
        int negativeCount = 0;        // Counts how many negative numbers exist
        int minAbsValue = Integer.MAX_VALUE; // Smallest absolute value in matrix

        // Traverse every cell in the matrix
        for (int[] row : matrix) {
            for (int value : row) {

                // Count negatives and convert to absolute value
                if (value < 0) {
                    negativeCount++;
                    value = -value;
                }

                // Add absolute value to total sum
                sum += value;

                // Track the smallest absolute value
                if (value < minAbsValue) {
                    minAbsValue = value;
                }
            }
        }

        /*
         * If the number of negative elements is odd,
         * one element must remain negative.
         * To minimize loss, we flip the smallest absolute value.
         * That reduces the sum by 2 * minAbsValue.
         */
        if ((negativeCount & 1) == 1) {
            sum -= (minAbsValue << 1); // same as 2 * minAbsValue
        }

        return sum;
    }
}
