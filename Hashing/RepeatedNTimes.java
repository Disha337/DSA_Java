//Leetcode 961 : N-Repeated Element in Size 2N Array
//Approach : HashSet
//Space Complexity : O(n)
//Time Complexity : O(n)
class Solution {
    public int repeatedNTimes(int[] nums) {

        HashSet set = new HashSet<>();
        //Iterate through the array
        for(int num:nums){
            //Set has property that it contain only the unique number not repeated
            //So if any number occur twice it will return that  number
            if(!set.add(num)){
                return num;
            }
        }

        //If there is no repated number occurs we will return -1
        return -1;
        
    }
}
