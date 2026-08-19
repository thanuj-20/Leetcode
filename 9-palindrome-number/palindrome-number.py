class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        org=x
        rev=0
        while x>0:
            di=x%10
            rev=rev*10+di
            x=x//10
        return org==rev

