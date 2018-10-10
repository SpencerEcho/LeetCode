#Longest Substring Without Repeating Characters
class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        tStr = ""
        maxLength = 0
        for c in s:
            if c in tStr:
                maxLength = len(tStr) if maxLength < len(tStr) else maxLength
                tStr = tStr[tStr.index(c)+1:]
            tStr += c
        return len(tStr) if maxLength < len(tStr) else maxLength 

def main():
    s1 = "abcabbb"
    s2 = "pwwkke2"
    s3 = "bbbbb"
    s4 = " "
    s5 = "dvdf"

    print(Solution().lengthOfLongestSubstring(s1))
    print(Solution().lengthOfLongestSubstring(s2))
    print(Solution().lengthOfLongestSubstring(s3))
    print(Solution().lengthOfLongestSubstring(s4))
    print(Solution().lengthOfLongestSubstring(s5))

if __name__ == '__main__':
    main()



