//Leetcode 67. Add Binary
//Level : Easy
//Technique : STring Builder
//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution{
  public String addBinary(String a, String b){
    int i = a.length()-1;
    int j = b.length()-1;
    int carry = 0;
    StringBuilder res = new StringBuilder();
    while(i>=0 || j>=0 || carry != 0){
      int sum = carry;
      if(i>=0){
        sum += a.charAt(i) - '0';
        i--;
      }
      if(j>=0){
        sum += b.charAt(j) - '0';
        j--;
      }
      res.append(sum%2);
      carry = sum/2;
    }
    return res.reverse().toString();
  }
}
