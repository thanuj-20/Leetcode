class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zer = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            zer[i] = count;
        }        
        int swa = 0;
        for (int i = 0; i < n; i++) {
            int required = n - i - 1;
            int j = i;
            while (j < n && zer[j] < required) {
                j++;
            }            
            if (j == n) return -1;
            while (j > i) {
                int temp = zer[j];
                zer[j] = zer[j - 1];
                zer[j - 1] = temp;
                j--;
                swa++;
            }
        }        
        return swa;
    }
}