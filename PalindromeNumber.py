class StringSolution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        s = str(x)
        return s == s[::-1]
class IntegerSolution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        temp = x
        reverseNumber = 0
        while(temp != 0):
            rvm = temp % 10
            temp = temp // 10
            reverseNumber =  reverseNumber*10 + rvm
        return (reverseNumber + x)/2 == x
def main():
    testCase = [121, -121, 10]
    ssol = StringSolution()
    for n in testCase:
        print(ssol.isPalindrome(n))
    isol = IntegerSolution()
    print("----------------------IntegerSolution------------------")
    for n in testCase:
        print(isol.isPalindrome(n))

if __name__ == "__main__":
    main()