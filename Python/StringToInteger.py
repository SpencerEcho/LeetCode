class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        MAX = 2**31 - 1
        MIN = 0 - 2**31
        str = str.lstrip()
        if len(str) == 0:
            return 0
        suffix = ""
        if str[0] == '+':
            str = str[1:]
        elif str[0] == '-':
            suffix = '-'
            str = str[1:]
        retValue = 0        
        for c in str:
            if ord(c) < 48 or ord(c) > 57:
                break
            retValue = retValue*10 + int(c)
        
        retValue = 0 - retValue if suffix == "-" else retValue
        if retValue>MAX:
            retValue = MAX
        elif retValue<MIN:
            retValue = MIN
        return retValue

def main():
    testCase = [" +0 123", "-91283472332", "", "  ", "- 4 5", "4193 with words", "words and 987", "-91283472332"]
    sol = Solution()
    for s in testCase:
        print(sol.myAtoi(s))

if __name__ == "__main__":
    main()