// Leetcode 349. Intersection of Two Arrays
//Approach : HashSet i.e Hashing
//Time : O(n+m) and Space : O(n+m)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int n : nums1) set.add(n);
        for (int n : nums2) {
            if (set.contains(n)) result.add(n);
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int n : result) ans[i++] = n;

        return ans;
    }
}
