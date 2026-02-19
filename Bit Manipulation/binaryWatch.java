//Leetcode 401. Binary Watch
//Level : Easy
//Technique Used : Brute force + Bit Manipulation
//Time Complexity : O(1)
//Space Complexity : O(1)

class Solution{
  public List<String> readBinaryWatch(int turnedOn){
    List<String> res = new ArrayList<>();
    for(int h=0; h<12; h++){
      for(int m=0; m<60; m++){
        if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
          res.add(String.format("%d:%02d",h,m));
        }
      }
    }
    return res;
  }
}
