class Solution:
    def isPalindrome(self, s: str) -> bool:
        newstr = ""
        s = s.lower()
        for ch in s:
            if ch.isalnum():
                newstr += ch
        l = 0
        r = len(newstr) - 1
        while l < r:
            if newstr[l] != newstr[r]:
                return False
            l += 1
            r -= 1
        return True
