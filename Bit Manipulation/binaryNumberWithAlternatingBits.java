//Leetcode 693. Binary Number with Alternating Bits
//Level : Easy
//Technique Used : Bit Manipulation
//Time Complexity : O(log n)
//Space Complexity : O(1)

class Solution{
  public boolean hasAlternatingBits(int n){
    //Get the last bit of n
    int prevBit = n&1;
    //Remove last bit
    n = n>>1;
    //continue until n is greater than 0
    while(n>0){
      //get current last bit
      int currBit = n&1;
      //If adjacent bits are same return false
      if(currBit == prevBit){
        return false;
      }
      //update prevBit and shift n for the next bit
      prevBit = currBit;
      n = n>>1;
    }
    return true;
  }
}
