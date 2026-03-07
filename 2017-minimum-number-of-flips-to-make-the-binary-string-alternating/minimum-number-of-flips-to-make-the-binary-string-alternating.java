class Solution {
    public int minFlips(String s) {
        int n=s.length();
        String t = s + s;
        int alt1 = 0;
        int alt2 = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < t.length(); r++) {
            char expected1 = (r % 2 == 0) ? '0' : '1';
            char expected2 = (r % 2 == 0) ? '1' : '0';
            if (t.charAt(r) != expected1) alt1++;
            if (t.charAt(r) != expected2) alt2++;
            if (r - l + 1 > n) {
                char left1 = (l % 2 == 0) ? '0' : '1';
                char left2 = (l % 2 == 0) ? '1' : '0';
                if (t.charAt(l) != left1) alt1--;
                if (t.charAt(l) != left2) alt2--;
                l++;
            }
            if (r - l + 1 == n) {
                res = Math.min(res, Math.min(alt1, alt2));
            }
        }
        return res;
    }
}