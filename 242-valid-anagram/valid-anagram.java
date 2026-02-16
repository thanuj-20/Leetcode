class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] co=new int[26];
        for(char c:s.toCharArray())
            co[c-'a']++;
        for(char c:t.toCharArray())
            co[c-'a']--;
        for(int x:co)
            if(x!=0) return false;
        return true;
    }
}