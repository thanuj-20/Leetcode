import bisect
from typing import List
from sortedcontainers import SortedList
class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        base=nums[0]
        need=k-1
        low=SortedList()
        high=SortedList()
        low_sum=0
        def add(x):
            nonlocal low_sum
            if len(low)<need:
                low.add(x)
                low_sum+=x
            else:
                if x<low[-1]:
                    high.add(low[-1])
                    low_sum-=low[-1]
                    low.pop()
                    low.add(x)
                    low_sum+=x
                else:
                    high.add(x)
        def remove(x):
            nonlocal low_sum
            if x in low:
                low.remove(x)
                low_sum-=x
                if high:
                    y=high[0]
                    high.pop(0)
                    low.add(y)
                    low_sum+=y
            else:
                high.remove(x)
        res=float('inf')
        for i in range(1,dist+2):
            add(nums[i])
        res=low_sum
        for i in range(dist+2,len(nums)):
            add(nums[i])
            remove(nums[i-(dist+1)])
            res=min(res,low_sum)
        return res+base
