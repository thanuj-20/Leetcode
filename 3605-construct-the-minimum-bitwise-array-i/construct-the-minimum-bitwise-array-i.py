from typing import List
class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        res=[]
        for p in nums:
            if p&(p-1)==0:
                res.append(-1)
                continue
            k=0
            x=p
            while x&1:
                k+=1
                x>>=1
            res.append(p-(1<<(k-1)))
        return res
