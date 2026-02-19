//Leetcode 461. Hamming Distance
//Level : Easy
//Technique Used : Bit Manipulation i.e XOR
//XOR return 1 if the bits are different
//Time Complexity : O(1)
//Space Complexity : O(1)

class Solution{
  public int hammingDistance(int x, int y){
    int xor = x ^ y; //xor x and y
    int count = 0;
    while(xor != 0){
      count += xor & 1; //check last bit if it is 1 count + 1
      xor = xor >> 1; //remove last bit
      }
    return count; // return result
  }
}


//By using Java inbuilt method bitCount()
/*
class Solution{
  public int hammingDistance(int x, int y){
    return Integer.bitCount(x ^ y);
  }
}
*/
