''' https://codingbat.com/python/String-2
Medium python string problems -- 1 loop.. Use + to combine strings, len(str) is
the number of chars in a String, str[i:j] extracts the substring starting at
index i and running up to but not including index j.
'''

''' https://codingbat.com/prob/p170842
Given a string, return a string where for every char in the original, there are
two chars.

double_char('The') → 'TThhee'
double_char('AAbb') → 'AAAAbbbb'
double_char('Hi-There') → 'HHii--TThheerree'
'''
def double_char(str):
  result = ""
  for c in str:
    result += c * 2
  return result

''' https://codingbat.com/prob/p167246
Return the number of times that the string "hi" appears anywhere in the given
string.

count_hi('abc hi ho') → 1
count_hi('ABChi hi') → 2
count_hi('hihi') → 2
'''
def count_hi(str):
    cnt = 0
    for i in range(0, len(str)-1):
        if "hi" == str[i:i+2]:
            cnt += 1
    return cnt

''' https://codingbat.com/prob/p164876
Return True if the string "cat" and "dog" appear the same number of times in the
given string.

cat_dog('catdog') → True
cat_dog('catcat') → False
cat_dog('1cat1cadodog') → True
'''
def cat_dog(str):
    cntDog = 0
    cntCat = 0
    substr = ""
    for i in range(0, len(str)-2):
        substr = str[i:i+3]
        if "cat" == substr:
            cntCat += 1
        if "dog" == substr:
            cntDog += 1
    return cntDog == cntCat

''' https://codingbat.com/prob/p186048
Return the number of times that the string "code" appears anywhere in the given
string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

count_code('aaacodebbb') → 1
count_code('codexxcode') → 2
count_code('cozexxcope') → 2
'''
def count_code(str):
    cnt = 0
    for i in range(0, len(str)-3):
        if str[i:i+2] == "co" and str[i+3] == "e":
            cnt += 1
    return cnt

''' https://codingbat.com/prob/p174314
Given two strings, return True if either of the strings appears at the very end
of the other string, ignoring upper/lower case differences (in other words, the
computation should not be "case sensitive"). Note: s.lower() returns the
lowercase version of a string.

end_other('Hiabc', 'abc') → True
end_other('AbC', 'HiaBc') → True
end_other('abc', 'abXabc') → True
'''
def end_other(a, b):
    return a[-len(b):].lower() == b.lower() or b[-len(a):].lower() == a.lower()

''' https://codingbat.com/prob/p149391
Return True if the given string contains an appearance of "xyz" where the xyz is
not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

xyz_there('abcxyz') → True
xyz_there('abc.xyz') → False
xyz_there('xyz.abc') → True
'''
def xyz_there(str):
    for i in range(0, len(str)-2):
        if str[i:i+3] == "xyz" and (i == 0 or str[i-1] != "."):
            return True
    return False
