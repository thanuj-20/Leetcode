class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        n=abs(n)
        pro=1
        sum=0
        while n>0:
            di=n%10
            pro*=di
            sum+=di
            n//=10
        return pro-sum
        