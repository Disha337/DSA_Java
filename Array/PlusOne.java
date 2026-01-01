//Leetcode 66 : Plus One
//Approach Used : Array and Math(Carry Handling)
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution{
  public int[] PlusOne(int[] digits){
    // Start from the last digit
    for(int i=digits.length-1; i>=0; i--){
      // If digit is less than 9, add 1 and return
      if(digits[i] < 9){
        digits[i]++;
        return digits;
      }
      // If digit is 9, set it to 0 and carry continues
      digits[i] = 0;
    }

    // If all digits were 9, create a new array
    int res[] = new int[digits.length+1];
    res[0] = 1;
    return res;
  }
}
