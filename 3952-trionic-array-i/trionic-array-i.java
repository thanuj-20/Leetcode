class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Phase 1: strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false;

        // Phase 2: strictly decreasing
        int j = i;
        while (j + 1 < n && nums[j] > nums[j + 1]) {
            j++;
        }
        // must have room for phase 3
        if (j == i || j == n - 1) return false;

        // Phase 3: strictly increasing
        int k = j;
        while (k + 1 < n && nums[k] < nums[k + 1]) {
            k++;
        }

        return k == n - 1;
    }
}
