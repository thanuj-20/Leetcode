class Solution {
    public int concatenatedBinary(int n) {
        long re = 0;
        int bits = 0;
        int MOD = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
                        if ((i & (i - 1)) == 0) {
                bits++;
            }
            re = ((re << bits) + i) % MOD;
        }

        return (int) re;
    }
}