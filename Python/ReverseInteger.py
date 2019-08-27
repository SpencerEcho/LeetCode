class StringSolution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        MAX = 2**31 - 1
        MIN = 0 - 2*31
        retValue = int(str(abs(x))[::-1])
        if x < 0:
            retValue = 0 - retValue
        return retValue if retValue < MAX and retValue > MIN else 0

class IntegerSolution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        MAX = 2**31 - 1
        MIN = 0 - 2**31
        retValue = 0
        while(x != 0):
            rem = x % 10 if x > 0 else x % -10
            x = x // 10 if x > 0 else -(x // -10)
            retValue = retValue * 10 + rem
            if retValue > MAX or retValue < MIN:
                return 0
        return retValue

def main():
    testCase = [-123, -123, 120, 0, 1534236469, -2147483648]
    # 321, -321, 21, 0, 0, 0
    # for number in testCase:
        # print(StringSolution().reverse(number))

    for number in testCase:
        print(IntegerSolution().reverse(number))
if __name__ == '__main__':
    main()