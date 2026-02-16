//Leetcode 190. Reverse Bits
//Level : Easy
//Technique Used : Bit manipulation
//Time Complexity : O(1)
//Space Complexity : O(1)

class Solution{
  public int reverseBits(int n){
    int res = 0;
    for(int i=0; i<32; i++){
      res = res << 1;
      int lastBit = n&1;
      res = res | lastBit;
      n = n >> 1;
    }
    return res;
  }
}
