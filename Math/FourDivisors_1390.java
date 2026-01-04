//Leetcode 1390 : Four Divisors(Medium)
//Approach : Math (Number Theory)
//Time Complexity : O(n)
//Space COmplexity : O(1)
class Solution {

    public int sumFourDivisors(int[] nums) {

        // This will store the final answer
        int totalSum = 0;

        // Loop through each number in the array
        for (int num : nums) {

            int divisorCount = 0;  // Count of divisors
            int divisorSum = 0;    // Sum of divisors

            // Find divisors from 1 to sqrt(num)
            for (int i = 1; i * i <= num; i++) {

                // If i divides num
                if (num % i == 0) {

                    int d1 = i;          // First divisor
                    int d2 = num / i;    // Paired divisor

                    // If both divisors are same (perfect square case)
                    if (d1 == d2) {
                        divisorCount += 1;
                        divisorSum += d1;
                    } 
                    // Otherwise count both divisors
                    else {
                        divisorCount += 2;
                        divisorSum += d1 + d2;
                    }

                    // If more than 4 divisors, no need to continue
                    if (divisorCount > 4) {
                        break;
                    }
                }
            }

            // If exactly 4 divisors, add their sum
            if (divisorCount == 4) {
                totalSum += divisorSum;
            }
        }

        return totalSum;
    }
}
