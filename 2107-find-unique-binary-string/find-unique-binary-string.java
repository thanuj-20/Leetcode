class Solution {
    public String findDifferentBinaryString(String[] nums) {        
        int n = nums.length;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0')
                ans.append('1');
            else
                ans.append('0');
        }
        return ans.toString();
    }
}