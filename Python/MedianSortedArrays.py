class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        return self.getMedian(self.makeNewList(nums1, nums2))

    def makeNewList(self, nums1, nums2):
        nums3 = []
        indexOfNums1 = 0
        indexOfNums2 = 0
        while indexOfNums1 < len(nums1) or indexOfNums2 < len(nums2):
            if indexOfNums1 == len(nums1):
                nums3.append(nums2[indexOfNums2])
                indexOfNums2 += 1
                continue

            if indexOfNums2 == len(nums2):
                nums3.append(nums1[indexOfNums1])
                indexOfNums1 += 1
                continue

            if nums1[indexOfNums1] < nums2[indexOfNums2]:
                nums3.append(nums1[indexOfNums1])
                indexOfNums1 += 1
            elif nums1[indexOfNums1] > nums2[indexOfNums2]:
                nums3.append(nums2[indexOfNums2])
                indexOfNums2 += 1
            else:
                nums3.append(nums1[indexOfNums1])
                nums3.append(nums2[indexOfNums2])
                indexOfNums1 += 1
                indexOfNums2 += 1
        return nums3

    def getMedian(self, nums):
        if len(nums) % 2 == 0:
            midIndex1 = len(nums) // 2 - 1
            midIndex2 = midIndex1 + 1
            return (nums[midIndex1] + nums[midIndex2]) / 2
        else:
            midIndex = len(nums) // 2
            return nums[midIndex]

def main():
    nums1 = [1, 3]
    nums2 = [2]
    nums3 = [3, 4]
    nums4 = [1, 2, 3]
    nums5 = [1, 2, 8]
    nums6 = [4, 5, 6]
    print(Solution().findMedianSortedArrays(nums1, nums2))
    print(Solution().findMedianSortedArrays(nums3, nums4))
    print(Solution().findMedianSortedArrays(nums5, nums6))

if __name__ == '__main__':
    main()