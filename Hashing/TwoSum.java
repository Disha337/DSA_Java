Leetcode #1
class Solution {
    public int[] twoSum(int[] nums, int target) {

        /*for(int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length; j++){

                if(nums[i]+nums[j]== target){
                return new int[]{i,j};
            }
            }            
        }

        return new int[]{};*/

        //Using HashMap

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            int need = target - curr;

            if(map.containsKey(need)){
                return new int[]{map.get(need), i};
            }

            map.put(curr,i);
        }

      return new int[]{};  
    }
}
