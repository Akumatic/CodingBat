''' https://codingbat.com/python/Warmup-2
Medium warmup string/list problems with loops (solutions available)
'''

''' https://codingbat.com/prob/p193507
Given a string and a non-negative int n, return a larger string that is n copies
of the original string.

string_times('Hi', 2) → 'HiHi'
string_times('Hi', 3) → 'HiHiHi'
string_times('Hi', 1) → 'Hi'
'''
def string_times(str, n):
    return str * n

''' https://codingbat.com/prob/p165097
Given a string and a non-negative int n, we'll say that the front of the string
is the first 3 chars, or whatever is there if the string is less than length 3.
Return n copies of the front;

front_times('Chocolate', 2) → 'ChoCho'
front_times('Chocolate', 3) → 'ChoChoCho'
front_times('Abc', 3) → 'AbcAbcAbc'
'''
def front_times(str, n):
    return str * n if len(str) < 3 else str[:3] * n

''' https://codingbat.com/prob/p113152
Given a string, return a new string made of every other char starting with the
first, so "Hello" yields "Hlo".

string_bits('Hello') → 'Hlo'
string_bits('Hi') → 'H'
string_bits('Heeololeo') → 'Hello'
'''
def string_bits(str):
    result = ""
    for i in range(0, len(str)):
        if i % 2 == 0:
            result += str[i]
    return result

''' https://codingbat.com/prob/p118366
Given a non-empty string like "Code" return a string like "CCoCodCode".

string_splosion('Code') → 'CCoCodCode'
string_splosion('abc') → 'aababc'
string_splosion('ab') → 'aab'
''' 
def string_splosion(str):
    result = ""
    for i in  range(0, len(str)):
        result += str[:i+1]
    return result