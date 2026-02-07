class Solution:
    def minimumDeletions(self, s: str) -> int:
        dp=0
        bCount=0
        for ch in s:
            if ch=='b':
                bCount+=1
            else:
                dp=min(dp+1,bCount)
        return dp
