//Leetcode 191. Number of 1 Bits
//Level : Easy
//Technique Used : Bit Manipulation
//Time Complexity : O(1)
//Space Complexity : O(1)

class Solution{
  public int hammingWeight(int n){
    int count = 0;
    while(n > 0){
      //Check for last bit if it 1 then increase the count by 1
      if((n&1) == 1){
        count++;
      }
      //remove the last bit so we can go to the next vit for count
      n = n>>1;
    }
    //Return the result i.e count of 1's
    return count;
  }
}

//By using bitCount() method we directly get the complete output i.e in just one line
//Basically the Integer.bitCount() is a java inbuilt method which counts the 1's in binary number
/* 
class Solution{
  public int hammingWeight(int n){
    return Integer.bitCount(n);
  }
}
*/
