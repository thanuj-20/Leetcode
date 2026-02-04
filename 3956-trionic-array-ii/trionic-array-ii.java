class Solution {
    int n;
    long[][] memo;
    static final long NEG_INF = Long.MIN_VALUE / 2;
    long solve(int i, int trend, int[] nums) {
        if (i == n) {
            return (trend == 3) ? 0 : NEG_INF;
        }
        if (memo[i][trend] != Long.MIN_VALUE) {
            return memo[i][trend];
        }
        long take = NEG_INF;
        long skip = NEG_INF;
        if (trend == 0) {
            skip = solve(i + 1, 0, nums);
        }
        if (trend == 3) {
            take = nums[i];
        }
        if (i + 1 < n) {
            int curr = nums[i];
            int next = nums[i + 1];
            if (trend == 0 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 1, nums));
            } 
            else if (trend == 1) {
                if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 1, nums));
                } else if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                }
            } 
            else if (trend == 2) {
                if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                } else if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 3, nums));
                }
            } 
            else if (trend == 3 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 3, nums));
            }
        }
        return memo[i][trend] = Math.max(take, skip);
    }
    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        memo = new long[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Long.MIN_VALUE);
        }
        return solve(0, 0, nums);
    }
}