//Leetcode 1266. Minimum Time Visiting All Points
//Approach : Greedy [moving between consecutive points in the minimum possible time (max of horizontal and vertical distances)]
//Time complexity	: O(n)
//Space complexity	: O(1)

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // Variable to store total minimum time needed
        int time = 0;
        // Loop through each pair of consecutive points
         for(int i=0; i<points.length-1; i++){
           // Current point coordinates
           int x1 = points[i][0];
           int y1 = points[i][1];  
           
         // Next point coordinates
           int x2 = points[i+1][0];
           int y2 = points[i+1][1];           

            // Calculate horizontal distance between the two points
            int dx = Math.abs(x2 - x1);

            // Calculate vertical distance between the two points
            int dy = Math.abs(y2 - y1);

            // Minimum time to go from current point to next point
            // We can move diagonally, so the time is the maximum of dx and dy
            time += Math.max(dx, dy);
        }

        // Return the total minimum time to visit all points
        return time;
    }
}

// Example: move from [1,1] → [3,4]
// dx = |3-1| = 2, dy = |4-1| = 3, time = max(2,3) = 3

