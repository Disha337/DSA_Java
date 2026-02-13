// Leetcode 3714. Longest Balanced Substring II
// Level : Medium
// Approach : Prefix Difference + Hashing + Sliding Window
// Technique : Count differences of letters, track first occurrence, array optimization for 2-letter case
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
  public int longestBalanced(String s){
    char[] c = s.toCharArray();
    int n = c.length;
    int res = 1;

    //One letter Streak
    int curr = 1;
    for(int i=1; i<n; i++){
      if(c[i] == c[i-1]){
        curr++;
      }else{
        curr = 1;
      }
      res = Math.max(res, curr);      
    }

    //Two Distinct Letters
    res = Math.max(res, findTwo(c, 'a', 'b'));
    res = Math.max(res, findTwo(c, 'a', 'c'));
    res = Math.max(res, findTwo(c, 'b', 'c'));

    //Three Distinct letters
    int cnta = 0, cntb = 0, cntc = 0;
    Map<String, Integer> map = new HashMap<>();
    map.put("0,0",-1);
    for(int i=0; i<n; i++){
      if(c[i] == 'a'){
        cnta++;
      }else if(c[i] == 'b'){
        cntb++;
      }else{
        cntc++;
      }

      if(cnta == cntb && cnta ==cntc){
        res = Math.max(res, cnta+cntb+cntc);
      }
      String key = (cnta - cntb) + "," + (cnta - cntc);
      if(map.containsKey(key)){
        res = Math.max(res, i-map.get(key));
      }else{
        map.put(key,i);
      }
    }
    return res;
  }
  private int findTwo(char[] c, char x, char y){
    int n = c.length;
    int maxLen = 0;

    int[] first = new int[2*n+1];
    Arrays.fill(first, -2);

    int diff = n;
    first[diff] = -1;

    int clearIdx = -1;
    for(int i=0; i<n; i++){
      if(c[i] == x){
        diff++;
      }else if(c[i] == y){
        diff--;
      }else{
        clearIdx = i;
        diff = n;
        first[diff] = clearIdx;
        continue;
      }
      if(first[diff] < clearIdx){
        first[diff] = i;
      }else{
        maxLen = Math.max(maxLen, i-first[diff]);
      }
    }
    return maxLen;
  }
}
