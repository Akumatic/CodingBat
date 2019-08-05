''' https://codingbat.com/python/List-2
Medium python list problems -- 1 loop.. Use a[0], a[1], ... to access elements
in a list, len(a) is the length.
'''

''' https://codingbat.com/prob/p189616
Return the number of even ints in the given array. Note: the % "mod" operator
computes the remainder, e.g. 5 % 2 is 1.

count_evens([2, 1, 2, 3, 4]) → 3
count_evens([2, 2, 0]) → 3
count_evens([1, 3, 5]) → 0
'''
def count_evens(nums):
    cnt = 0
    for n in nums:
        if n % 2 == 0:
            cnt += 1
    return cnt

''' https://codingbat.com/prob/p184853
Given an array length 1 or more of ints, return the difference between the
largest and smallest values in the array. Note: the built-in min(v1, v2) and
max(v1, v2) functions return the smaller or larger of two values.

big_diff([10, 3, 5, 6]) → 7
big_diff([7, 2, 10, 9]) → 8
big_diff([2, 10, 7, 2]) → 8
'''
def big_diff(nums):
    min = float("inf")
    max = float("-inf")
    for n in nums:
        if n < min:
            min = n
        if n > max:
            max = n
    return max - min

''' https://codingbat.com/prob/p126968
Return the "centered" average of an array of ints, which we'll say is the mean
average of the values, except ignoring the largest and smallest values in the
array. If there are multiple copies of the smallest value, ignore just one copy,
and likewise for the largest value. Use int division to produce the final
average. You may assume that the array is length 3 or more.

centered_average([1, 2, 3, 4, 100]) → 3
centered_average([1, 1, 5, 5, 10, 8, 7]) → 5
centered_average([-10, -4, -2, -4, -2, 0]) → -3
'''
def centered_average(nums):
    min = float("inf")
    max = float("-inf")
    sum = 0
    for n in nums:
        if n < min:
            min = n
        if n > max:
            max = n
        sum += n
    return (sum - min - max) / (len(nums)-2)

''' https://codingbat.com/prob/p167025
Return the sum of the numbers in the array, returning 0 for an empty array.
Except the number 13 is very unlucky, so it does not count and numbers that come
immediately after a 13 also do not count.

sum13([1, 2, 2, 1]) → 6
sum13([1, 1]) → 2
sum13([1, 2, 2, 1, 13]) → 6
'''
def sum13(nums):
    sum = 0
    i = 0
    while i < len(nums):
        if nums[i] == 13:
            i += 2
        else:
            sum += nums[i]
            i += 1
    return sum

''' https://codingbat.com/prob/p108886
Return the sum of the numbers in the array, except ignore sections of numbers
starting with a 6 and extending to the next 7 (every 6 will be followed by at
least one 7). Return 0 for no numbers.

sum67([1, 2, 2]) → 5
sum67([1, 2, 2, 6, 99, 99, 7]) → 5
sum67([1, 1, 6, 7, 2]) → 4
'''
def sum67(nums):
    sum = 0
    count = True
    for n in nums:
        if count:
            if n == 6:
                count = False
                continue
            sum += n
        else:
            if n == 7:
                count = True
    return sum

''' https://codingbat.com/prob/p119308
Given an array of ints, return True if the array contains a 2 next to a 2
somewhere.

has22([1, 2, 2]) → True
has22([1, 2, 1, 2]) → False
has22([2, 1, 2]) → False
'''
def has22(nums):
    for i in range(0, len(nums)-1):
        if nums[i:i+2] == [2, 2]:
            return True
    return False