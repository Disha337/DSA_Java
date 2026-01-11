//Leetcode 85.Maximal Rectangle
//Approach : DP + Monotonic Stack using Histogram transformation
//Time Complexity : O(m × n) 
//Space Complexity : O(n)

class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Edge case: empty matrix
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // heights[j] stores the height of consecutive '1's ending at current row for column j
        // Extra column at the end acts as a sentinel (height = 0)
        int[] heights = new int[cols + 1];

        int maxArea = 0;

        // Process each row as the base of a histogram
        for (int i = 0; i < rows; i++) {

            // Step 1: Build / update histogram heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;   // extend vertical bar
                } else {
                    heights[j] = 0;    // reset height
                }
            }

            // Step 2: Find largest rectangle in histogram using monotonic stack
            // Using array instead of Stack<> for speed
            int[] stack = new int[cols + 1];
            int top = -1;

            // Traverse all columns + sentinel
            for (int j = 0; j <= cols; j++) {

                // Maintain increasing heights in stack
                while (top >= 0 && heights[stack[top]] > heights[j]) {

                    // Height of rectangle
                    int height = heights[stack[top--]];

                    // Width calculation
                    int width;
                    if (top == -1) {
                        // Stack empty → rectangle spans from 0 to j
                        width = j;
                    } else {
                        // Rectangle spans between current index and previous smaller bar
                        width = j - stack[top] - 1;
                    }

                    // Update maximum area
                    maxArea = Math.max(maxArea, height * width);
                }

                // Push current index onto stack
                stack[++top] = j;
            }
        }

        return maxArea;
    }
}
