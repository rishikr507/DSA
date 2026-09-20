class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        freq1 = {}
        for c in s:
            if c in freq1:
                freq1[c] += 1
            else:
                freq1[c] = 1

        freq2 = {}
        for c in t:
            if c in freq2:
                freq2[c] += 1
            else:
                freq2[c] = 1

        for k in freq1.keys():
            if k not in freq2 or freq2[k] != freq1[k]:
                return False

        return True
