# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        return self.reversOfInt(self.sumOfList(l1) + self.sumOfList(l2))
    
    def sumOfList(self, lt):
        numOfLt=0
        i=0
        while(lt != None):
            numOfLt += lt.val * pow(10,i)
            lt = lt.next
            i += 1
        return numOfLt

    def reversOfInt(self, sumOfL):
        r=[]
        if (sumOfL == 0):
            r.append(0)
            return r
        while(sumOfL / 10 != 0):
            addition = sumOfL // 10
            residue = sumOfL % 10
            sumOfL = addition
            r.append(residue)
        return r

class TestCase:
    def makeListNode(self, list):
        headNode = ListNode(0)
        curNode = headNode
        for num in list:
            newNode = ListNode(num)
            curNode.next = newNode
            curNode = newNode
        return headNode.next
    @classmethod
    def getSolution(cls, l1, l2):
        sl = Solution()
        return sl.addTwoNumbers(cls().makeListNode(l1), cls().makeListNode(l2))


print("[2,4,3], [5,6,4]: ", TestCase.getSolution([2,4,3], [5,6,4]))
print("[0], [0]: ", TestCase.getSolution([0], [0]))
