class Solution:
    def minimumDeletions(self, nums: list[int]) -> int:
        n = len(nums)
        mini = nums.index(min(nums))
        maxi = nums.index(max(nums))

        left = min(maxi, mini)
        right = max(maxi, mini)

        return min(left + 1 + n - right, n - left, right + 1)
