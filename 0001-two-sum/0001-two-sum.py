class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        ans = [-1, -1]
        hashMap = {}
        for i in range(len(nums)):
            rem = target - nums[i]
            if rem in hashMap.keys():
                return [hashMap.get(rem), i]
            else:
                hashMap[nums[i]] = i

        return [-1, -1]
