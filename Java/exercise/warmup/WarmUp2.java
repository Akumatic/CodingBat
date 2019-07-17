package exercise.warmup;
public class WarmUp2 {
    /** https://codingbat.com/prob/p142270
     * Given a string and a non-negative int n, return a larger string that is
     * n copies of the original string.
     * 
     * stringTimes("Hi", 2) → "HiHi"
     * stringTimes("Hi", 3) → "HiHiHi"
     * stringTimes("Hi", 1) → "Hi"
     */
    public String stringTimes(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++){
          result += str;
        }
        return result;
    }
      
    /** https://codingbat.com/prob/p101475
     * Given a string and a non-negative int n, we'll say that the front of the
     * string is the first 3 chars, or whatever is there if the string is less
     * than length 3. Return n copies of the front;
     * 
     * frontTimes("Chocolate", 2) → "ChoCho"
     * frontTimes("Chocolate", 3) → "ChoChoCho"
     * frontTimes("Abc", 3) → "AbcAbcAbc"
     */
    public String frontTimes(String str, int n) {
        String result = "";
        String front = (str.length() < 3) ? str : str.substring(0,3);
        for (int i = 0; i < n; i++){
          result += front;
        }
        return result;
    }

    /** https://codingbat.com/prob/p194667 
     * Count the number of "xx" in the given string. We'll say that overlapping
     * is allowed, so "xxx" contains 2 "xx".
     * 
     * countXX("abcxx") → 1
     * countXX("xxx") → 2
     * countXX("xxxx") → 3
    */
    int countXX(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == 'x' && str.charAt(i+1) == 'x') {
                cnt++;
            }
        }
        return cnt;
    }
      
    /** https://codingbat.com/prob/p186759 
     * Given a string, return true if the first instance of "x" in the string
     * is immediately followed by another "x".
     * 
     * doubleX("axxbb") → true
     * doubleX("axaxax") → false
     * doubleX("xxxxx") → true
    */
    boolean doubleX(String str) {
        for (int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == 'x'){
                return (str.charAt(i+1)) == 'x' ? true : false;
            }
        }
        return false;
    }
    
    /** https://codingbat.com/prob/p165666 
     * Given a string, return a new string made of every other char starting
     * with the first, so "Hello" yields "Hlo".
     * 
     * stringBits("Hello") → "Hlo"
     * stringBits("Hi") → "H"
     * stringBits("Heeololeo") → "Hello"
    */
    public String stringBits(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i+=2){
            result += str.charAt(i);
        }
        return result;
    }
    
    /** https://codingbat.com/prob/p117334
     * Given a non-empty string like "Code" return a string like "CCoCodCode".
     * 
     * stringSplosion("Code") → "CCoCodCode"
     * stringSplosion("abc") → "aababc"
     * stringSplosion("ab") → "aab"
     */
    public String stringSplosion(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i++){
            result += str.substring(0, i+1);
        }
        return result;
    }

    /** https://codingbat.com/prob/p178318
     * Given a string, return the count of the number of times that a substring
     * length 2 appears in the string and also as the last 2 chars of the
     * string, so "hixxxhi" yields 1 (we won't count the end substring).
     * 
     * last2("hixxhi") → 
     * last2("xaxxaxaxx") → 1
     * last2("axxxaaxx") → 2
     */
    public int last2(String str) {
        int len = str.length();
        if(len < 4) return 0;
        int cnt = 0;
        String pattern = str.substring(len-2, len);
        for(int i = 0; i < len-2; i++){
            if(str.substring(i, i+2).equals(pattern)) cnt++;
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p184031
     * Given an array of ints, return the number of 9's in the array.
     * 
     * arrayCount9([1, 2, 9]) → 1
     * arrayCount9([1, 9, 9]) → 2
     * arrayCount9([1, 9, 9, 3, 9]) → 3
     */
    public int arrayCount9(int[] nums) {
        int cnt = 0;
        for (int i : nums) {
            if (i == 9) cnt++;
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p186031
     * Given an array of ints, return true if one of the first 4 elements in
     * the array is a 9. The array length may be less than 4.
     * 
     * arrayFront9([1, 2, 9, 3, 4]) → true
     * arrayFront9([1, 2, 3, 4, 9]) → false
     * arrayFront9([1, 2, 3, 4, 5]) → false
     */
    public boolean arrayFront9(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 9) return true;
            if (i == 3) break;
        }
        return false;
    }

    /** https://codingbat.com/prob/p136041
     * Given an array of ints, return true if the sequence of numbers 1, 2, 3
     * appears in the array somewhere.
     * 
     * array123([1, 1, 2, 3, 1]) → true
     * array123([1, 1, 2, 4, 1]) → false
     * array123([1, 1, 2, 1, 2, 3]) → true
     */
    public boolean array123(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3) return true;
        }
        return false;
    }

    /** https://codingbat.com/prob/p198640
     * Given 2 strings, a and b, return the number of the positions where they
     * contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
     * since the "xx", "aa", and "az" substrings appear in the same place in 
     * both strings.
     * 
     * stringMatch("xxcaazz", "xxbaaz") → 3
     * stringMatch("abc", "abc") → 2
     * stringMatch("abc", "axc") → 0
    */
    public int stringMatch(String a, String b) {
        if (a.length() > b.length()){
            String temp = b;
            b = a;
            a = temp;
        }
        int len = a.length();
        int cnt = 0;
        for(int i = 0; i < len -1; i++){
            if(a.substring(i, i+2).equals(b.substring(i, i+2))) cnt++;
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p171260
     * Given a string, return a version where all the "x" have been removed.
     * Except an "x" at the very start or end should not be removed.
     * 
     * stringX("xxHxix") → "xHix"
     * stringX("abxxxcd") → "abcd"
     * stringX("xabxxxcdx") → "xabcdx"
     */
    public String stringX(String str) {
        String result = "";
        if(str.length() < 2) return str;
        for(int i = 1; i < str.length() -1; i++){
            if(str.charAt(i) == 'x') continue;
            result += str.charAt(i);
        }
        return str.charAt(0) + result + str.charAt(str.length()-1);
    }

    /** https://codingbat.com/prob/p121596
     * Given a string, return a string made of the chars at indexes 0,1, 4,5,
     * 8,9 ... so "kittens" yields "kien".
     * 
     * altPairs("kitten") → "kien"
     * altPairs("Chocolate") → "Chole"
     * altPairs("CodingHorror") → "Congrr"
     */
    public String altPairs(String str) {
        String result = "";
        int len = str.length();
        for(int i = 0; i < len; i+=4){
            result += str.charAt(i);
            if(i < len -1) result += str.charAt(i+1);
        }
        return result;
    }

    /** https://codingbat.com/prob/p126212
     * Suppose the string "yak" is unlucky. Given a string, return a version
     * where all the "yak" are removed, but the "a" can be any char. The "yak"
     * strings will not overlap.
     * 
     * stringYak("yakpak") → "pak"
     * stringYak("pakyak") → "pak"
     * stringYak("yak123ya") → "123ya"
     */
    public String stringYak(String str) {
        String result = "";
        int len = str.length();
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == 'y'){
                if(i < len -2 && str.charAt(i+2) == 'k'){
                    i += 2;
                    continue;
                }
            }
            result += str.charAt(i);
        }
        return result;
    }

    /** https://codingbat.com/prob/p110019
     * Given an array of ints, return the number of times that two 6's are
     * next to each other in the array. Also count instances where the second
     * "6" is actually a 7.
     * 
     * array667([6, 6, 2]) → 1
     * array667([6, 6, 2, 6]) → 1
     * array667([6, 7, 2, 6]) → 1
     */
    public int array667(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length -1; i++){
            if(nums[i] == 6 && (nums[i+1] == 6 || nums[i+1] == 7)) cnt++;
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p170221
     * Given an array of ints, we'll say that a triple is a value appearing 3
     * times in a row in the array. Return true if the array does not contain
     * any triples.
     * 
     * noTriples([1, 1, 2, 2, 1]) → true
     * noTriples([1, 1, 2, 2, 2, 1]) → false
     * noTriples([1, 1, 1, 2, 2, 2, 1]) → false
     */
    public boolean noTriples(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++){
            if(nums[i] == nums[i+1] && nums[i] == nums[i+2]) return false;
        }
        return true;
    }

    /** https://codingbat.com/prob/p167430
     * Given an array of ints, return true if it contains a 2, 7, 1 pattern: a
     * value, followed by the value plus 5, followed by the value minus 1.
     * Additionally the 271 counts even if the "1" differs by 2 or less from
     * the correct value.
     */
    public boolean has271(int[] nums) {
        int[] vals = {-3, -2, -1, 0, 1};
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] + 5 == nums[i+1]){
                for(int j : vals){
                    if(nums[i]+j == nums[i+2]) return true;
                } 
            }
        }
        return false;
    }
}