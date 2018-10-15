class BadSolution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        outStr1 = s[0]
        outStr2 = s[0]
        for i in range(len(s)//2):
            j = i+1
            while(((j-i) <= (len(s)-i) // 2) or ((j-i) <= (len(s)-i-1) // 2)):
                curLen = j-i
                if s[i:j][::-1] == s[j:j+curLen]:
                    tempStr = s[i:j+curLen]
                    outStr1 =tempStr if len(tempStr) > len(outStr1) else outStr1
                if s[i:j][::-1] == s[j+1:j+curLen+1]:
                    tempStr = s[i:j+curLen+1]
                    outStr2 =tempStr if len(tempStr) > len(outStr2) else outStr2
                j += 1
        return outStr1 if len(outStr1) > len(outStr2) else outStr2

class BetterSolution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        start = 0
        end = 0
        for i in range(len(s)):
            #  case: bab
            firstCase = self.findTheLongestIndex(s, i, i)
            # case: bb
            secondCase = self.findTheLongestIndex(s, i, i+1)
            maxLen = max(firstCase, secondCase)
            if maxLen > (end - start):
                start = i - (maxLen-1)//2
                end = i + maxLen//2
        return s[start:end+1]
    
    def findTheLongestIndex(self, s, left, right):
        while left>=0 and right<len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return right-left-1
    
def main():
    import datetime
    str1 = "cbabed"
    str2 = "acbaabc"
    str3 = "ccc"
    str4 = "acc"
    # str5 = ""
    str5 = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"
    print(BetterSolution().longestPalindrome(str1))
    print(BetterSolution().longestPalindrome(str2))
    print(BetterSolution().longestPalindrome(str3))
    print(BetterSolution().longestPalindrome(str4))
    print(BetterSolution().longestPalindrome(str5)) 
    # print(datetime.datetime.now())
    # print(BadSolution().longestPalindrome(str6))  
    # print(datetime.datetime.now())
    # print(datetime.datetime.now())
    # print(BetterSolution().longestPalindrome(str6))  
    # print(datetime.datetime.now())



if __name__ == "__main__":
    main()