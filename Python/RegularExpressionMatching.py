class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        return self.match(s,p)
    def match(self, text, pattern):
        if not pattern: return not text
        first_match = bool(text) and pattern[0] in {text[0], '.'}
        return first_match and self.match(text[1:], pattern[1:])
def main():
    # testCase = [("aaa", "a.."), ("", ".*"), ("aaa", "a"), ("aa", "a*"), ("ab", ".*"), ("aab", "c*a*b"), ("mississippi", "mis*is*p*.")]
    testCase = [ ("aa", "..")]
    
    sol = Solution()
    for case in testCase:
        print(sol.isMatch(case[0], case[1]))

if __name__ == "__main__":
    main()