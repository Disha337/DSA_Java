//Leetcode 3453. Separate Squares I
//Approach : Binary Search
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public double separateSquares(int[][] squares) {

        // 1. Find total area and search range
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] sq : squares) {
            double y = sq[1];
            double len = sq[2];

            totalArea += len * len;

            low = Math.min(low, y);
            high = Math.max(high, y + len);
        }

        double target = totalArea / 2.0;

        // 2. Binary search for y-coordinate
        for (int i = 0; i < 60; i++) { // enough for 1e-5 precision
            double mid = (low + high) / 2.0;

            if (areaBelow(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // 3. Calculate area below a horizontal line at height y
    private double areaBelow(int[][] squares, double y) {
        double area = 0;

        for (int[] sq : squares) {
            double bottom = sq[1];
            double len = sq[2];
            double top = bottom + len;

            if (y <= bottom) {
                // line is below the square → no area
                continue;
            } else if (y >= top) {
                // square fully below the line
                area += len * len;
            } else {
                // line cuts the square
                area += (y - bottom) * len;
            }
        }

        return area;
    }
}
