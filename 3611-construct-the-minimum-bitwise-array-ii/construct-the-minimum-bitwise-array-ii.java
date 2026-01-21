class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int f = nums.size();
        int[] y = new int[f];
        for (int e = 0; e < f; e++) {
            int o = nums.get(e);
            if ((o & (o - 1)) == 0) {
                y[e] = -1;
                continue;
            }
            int p = o;
            int d = 0;
            while ((p & 1) == 1) {
                d++;
                p >>= 1;
            }
            y[e] = o - (1 << (d - 1));
        }
        return y;
    }
}
