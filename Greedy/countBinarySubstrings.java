//Leetcode 696. Count Binary Substrings
//Level : Easy
//Technique Used : Greedy + Group Counting
//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution{
  public int countBinarySubstrings(String s){
    int prev = 0; //length of previous group
    int curr = 1; // length of current group
    int count = 0;

    for(int i=1; i<s.length(); i++){
      if(s.charAt(i) == s.charAt(i-1)){ //If the numbers are same increase the current
        curr++;
      }
      else{
        count += Math.min(prev, curr); //It counts when group changes
        prev = curr;
        curr = 1;
      }
    }
    count += Math.min(prev, curr);//It counts final group pair
    return count;      
  }
}
