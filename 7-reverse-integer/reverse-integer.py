class Solution:
    def reverse(self, x: int) -> int:
        sign=-1 if x<0 else 1
        x=abs(x)
        rev=0
        while x>0:
            di=x%10
            rev=rev*10+di
            x=x // 10
        if rev<-2**31 or rev>2**31-1:
            return 0
        return sign*rev