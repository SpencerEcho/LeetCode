class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, indexNumber in enumerate(nums):
            anotherNumber = target - indexNumber
            if (anotherNumber in nums) and (i != nums.index(anotherNumber)):
                return (i, nums.index(anotherNumber))

class TestCase:
    @staticmethod
    def getSolution(list, target):
        s = Solution()
        return s.twoSum(list, target)

print(TestCase.getSolution([2, 7, 2, 7], 9))
print(TestCase.getSolution([3, 4, 2], 6))
