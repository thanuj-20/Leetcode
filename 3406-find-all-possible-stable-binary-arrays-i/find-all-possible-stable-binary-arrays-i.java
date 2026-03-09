class Solution {

    int MOD = 1000000007;
    Integer[][][][] t;

    public int numberOfStableArrays(int e, int i, int pa) {

        t = new Integer[e + 1][i + 1][2][pa + 1];

        long r = 0;

        if (e > 0)
            r = (r + f(e - 1, i, 0, 1, pa)) % MOD;

        if (i > 0)
            r = (r + f(e, i - 1, 1, 1, pa)) % MOD;

        return (int) r;
    }

    private int f(int e, int i, int c, int r, int pa) {

        if (e == 0 && i == 0)
            return 1;

        if (t[e][i][c][r] != null)
            return t[e][i][c][r];

        long ans = 0;

        if (c == 0) {

            if (e > 0 && r < pa)
                ans = (ans + f(e - 1, i, 0, r + 1, pa)) % MOD;

            if (i > 0)
                ans = (ans + f(e, i - 1, 1, 1, pa)) % MOD;

        } else {

            if (i > 0 && r < pa)
                ans = (ans + f(e, i - 1, 1, r + 1, pa)) % MOD;

            if (e > 0)
                ans = (ans + f(e - 1, i, 0, 1, pa)) % MOD;
        }

        return t[e][i][c][r] = (int) ans;
    }
}