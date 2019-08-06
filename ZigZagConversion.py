
# Input: PAYPALISHIRING, numsRows = 3
# P   A   H   N
# A P L S I I G
# Y   I   R
# Output: PAHNAPLSIIGYIR

class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        strRows = []
        rowNumber = min(numRows, len(s))
        for i in range(rowNumber):
            strRows.append("")
        
        goDown = True
        count = 0
        for i in range(len(s)):
            strRows[count] += s[i]
            if count == 0:
                goDown = True
            if count == rowNumber-1:
                goDown = False
            count += 1 if goDown else -1 
        return "".join(strRows)

def main():
    # Output: "PAHNAPLSIIGYIR", "PINALSIGYAHRPI", ""
    testCase = [("PAYPALISHIRING",3), ("PAYPALISHIRING",4), ("",5)]
    for t in testCase:
        print(Solution().convert(t[0], t[1]))

if(__name__ == "__main__"):
    main()