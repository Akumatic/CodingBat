package exercise.array;

/** https://codingbat.com/java/Array-3
 *  Harder array problems -- 2 loops, more complex logic. See the Java Arrays
 * and Loops document for help.
 * https://codingbat.com/doc/java-array-loops.html
 */

class Array3 {
    /** https://codingbat.com/prob/p189576
     * Consider the leftmost and righmost appearances of some value in an array.
     * We'll say that the "span" is the number of elements between the two
     * inclusive. A single value has a span of 1. Returns the largest span found
     * in the given array. (Efficiency is not a priority.)
     * 
     * maxSpan([1, 2, 1, 1, 3]) → 4
     * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */
    public int maxSpan(int[] nums) {
        int max = 0;
        int cnt = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == curr) cnt = j - i + 1;
            }
            if (cnt > max) max = cnt;
        }
        return max;
    }
      
    /** https://codingbat.com/prob/p159339
     * Return an array that contains exactly the same numbers as the given
     * array, but rearranged so that every 3 is immediately followed by a 4. Do
     * not move the 3's, but every other number may move. The array contains the
     * same number of 3's and 4's, every 3 has a number after it that is not a 
     * 3, and a 3 appears in the array before any 4.
     * 
     * fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
     * fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
     * fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
      */
    public int[] fix34(int[] nums) {
        int numOf4 = 0;
        //get number of 3 and 4
        for (int num : nums) {
            if (num == 4) numOf4++;
        }
        int[] indexOf4 = new int[numOf4];
        int[] indexOf5 = new int[numOf4];
        int cnt4 = 0;
        int cnt5 = 0;
        //store Index of 3 and 4
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 4) {
                indexOf4[cnt4] = i;
                cnt4++;
            }
            if (nums[i] == 4) {
                indexOf5[cnt5] = i;
                cnt5++;
            }
        }
        //compare indices and swap if needed
        for (int i = 0; i < indexOf4.length; i++) {
            if (indexOf4[i] + 1 == indexOf4[i]) continue;
            int temp = nums[indexOf4[i] + 1];
            nums[indexOf4[i] + 1] = 4;
            nums[indexOf5[i]] = temp;
        }
        return nums;
    }

    /** https://codingbat.com/prob/p125819
     * (This is a slightly harder version of the fix34 problem.) Return an array
     * that contains exactly the same numbers as the given array, but rearranged
     * so that every 4 is immediately followed by a 5. Do not move the 4's, but
     * every other number may move. The array contains the same number of 4's
     * and 5's, and every 4 has a number after it that is not a 4. In this
     * version, 5's may appear anywhere in the original array.
     * 
     * fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
     * fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
     * fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
     */
    public int[] fix45(int[] nums) {
        int numOf4 = 0;
        //get number of 3 and 4
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4 && nums[i+1] != 5) numOf4++;
        }
        int[] indexOf4 = new int[numOf4];
        int[] indexOf5 = new int[numOf4];
        int cnt4 = 0;
        int cnt5 = 0;
        //store Index of 3 and 4
        for (int i = 0; i < nums.length; i++){
            if (i < nums.length - 1 && nums[i] == 4 && nums[i+1] != 5) {
                indexOf4[cnt4] = i;
                cnt4++;
                continue;
            }
            if (nums[i] == 5 && (i == 0 || nums[i-1] != 4)) {
                indexOf5[cnt5] = i;
                cnt5++;
                continue;
            }
        }
        //compare indices and swap if needed
        for (int i = 0; i < indexOf4.length; i++) {
            int temp = nums[indexOf4[i] + 1];
            nums[indexOf4[i] + 1] = 5;
            nums[indexOf5[i]] = temp;
        }
        return nums;
    }
      

    /** https://codingbat.com/prob/p158767
     * Given a non-empty array, return true if there is a place to split the
     * array so that the sum of the numbers on one side is equal to the sum of
     * the numbers on the other side.
     * 
     * canBalance([1, 1, 1, 2, 1]) → true
     * canBalance([2, 1, 1, 2, 1]) → false
     * canBalance([10, 10]) → true
     */
    public boolean canBalance(int[] nums) {
        int sumL = 0;
        int sumR = 0;
        for (int num : nums) {
            sumR += num;
        }
        for (int i = 0; i < nums.length; i++) {
            sumL += nums[i];
            sumR -= nums[i];
            if (sumL == sumR) return true;
        }
        return false;
    }

    /** https://codingbat.com/prob/p134022
     * Given two arrays of ints sorted in increasing order, outer and inner,
     * return true if all of the numbers in inner appear in outer. The best
     * solution makes only a single "linear" pass of both arrays, taking
     * advantage of the fact that both arrays are already in sorted order.
     * 
     * linearIn([1, 2, 4, 6], [2, 4]) → true
     * linearIn([1, 2, 4, 6], [2, 3, 4]) → false
     * linearIn([1, 2, 4, 4, 6], [2, 4]) → true
     */
    public boolean linearIn(int[] outer, int[] inner) {
        if (inner.length == 0) return true;
        int index = 0;
        for (int i = 0; i < outer.length; i++) {
            if (outer[i] == inner[index]) {
                index++;
                if (index == inner.length) return true;
            }
        }
        return false; 
    }

    /** https://codingbat.com/prob/p155405
     * Given n>=0, create an array length n*n with the following pattern, shown
     * here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show
     * the 3 groups).
     * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
     * squareUp(2) → [0, 1, 2, 1]
     * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
     */
    public int[] squareUp(int n) {
        int[] arr = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j*n + i] = ((n-1-j) <= i) ? n - i : 0;
            }
        }
        return arr;
    }
    
    /** https://codingbat.com/prob/p104090
     * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,  
     * ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the
     * length of the array will be 1 + 2 + 3 ... + n, which is known to sum to
     * exactly n*(n + 1)/2.
     * 
     * seriesUp(3) → [1, 1, 2, 1, 2, 3]
     * seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
     * seriesUp(2) → [1, 1, 2]
     */
    public int[] seriesUp(int n) {
        int[] arr = new int[n*(n + 1)/2];
        int index = 0;
        int limit = 1;
        int cnt = 1;
        while (index < arr.length) {
            while(cnt < limit + 1){
                arr[index] = cnt;
                index++;
                cnt++;
            }
            cnt = 1;
            limit++;
        }
        return arr;
    }

    /** https://codingbat.com/prob/p196409
     * We'll say that a "mirror" section in an array is a group of contiguous
     * elements such that somewhere in the array, the same group appears in
     * reverse order. For example, the largest mirror section in
     * {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the
     * size of the largest mirror section found in the given array.
     * 
     * maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
     * maxMirror([1, 2, 1, 4]) → 3
     * maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
     */
    public int maxMirror(int[] nums) {
        int len = nums.length;
        int max = 0;
        int size;
        int start;
        int end;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {
                size = 0;
                start = i;
                end = j;
                while (start < len && end >= 0 && nums[start] == nums[end]) {
                    size++;
                    start++;
                    end--;
                }
                if (size > max) max = size;
            }
        }
        return max;
    }

    /** https://codingbat.com/prob/p193817
     * Say that a "clump" in an array is a series of 2 or more adjacent elements
     * of the same value. Return the number of clumps in the given array.
     * 
     * countClumps([1, 2, 2, 3, 4, 4]) → 2
     * countClumps([1, 1, 2, 1, 1]) → 2
     * countClumps([1, 1, 1, 1, 1]) → 1
    */
    public int countClumps(int[] nums) {
        int cnt = 0;
        boolean clump = false;
        for (int i = 0; i < nums.length - 1; i++){
            if (clump && nums[i] == nums[i+1]) continue;
            if (clump && nums[i] != nums[i+1]) {
                clump = false;
                continue;
            }
            if (!clump && nums[i] == nums[i+1]) {
                cnt++;
                clump = true;
            }
        }
        return cnt;
    }
      
}