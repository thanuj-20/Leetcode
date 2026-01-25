class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        if k==1:
            return 0
        nums.sort()
        anss=float('inf')
        for i in range(len(nums)-k+1):
            anss=min(anss,nums[i+k-1]-nums[i])
        return anss