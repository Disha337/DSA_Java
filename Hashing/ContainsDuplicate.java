//Leetcode 217
class Solution {
    public boolean containsDuplicate(int[] nums) {

        //It requires too much time so time limit exceeded
        /*for(int i=0; i<nums.length-1; i++){
            Arrays.sort(nums);
            if(nums[i] == nums[i+1]){
                return true;
            }
        }

        return false;*/


        //Using set because set doesn't contain duplicate elements

        HashSet set=new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
        
    }
}
