// LeetCode #242 - Valid Anagram
// Approach: Character frequency array
// Time: O(n), Space: O(1)

//Basically Anagram is nothing but equal number of charcters i.e same length and same characters sequence doen't matter
//For example s="toy" and t="yot" it will return true because it is anagram
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int[] count=new int[26];
        for(int i=0; i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int c : count){
            if(c!=0){
                return false;
            }
        }
        return true;        
    }
}
