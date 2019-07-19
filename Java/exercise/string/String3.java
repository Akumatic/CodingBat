package exercise.string;

/** https://codingbat.com/java/String-3
 * Harder String problems -- 2 loops. See the Java String Help document for help
 * with strings.
 * https://codingbat.com/doc/java-string-introduction.html
 */

class String3 {
    /** https://codingbat.com/prob/p199171
     * Given a string, count the number of words ending in 'y' or 'z' -- so the
     * 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow"
     * (not case sensitive). We'll say that a y or z is at the end of a word if
     * there is not an alphabetic letter immediately following it.
     * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * 
     * countYZ("fez day") → 2
     * countYZ("day fez") → 2
     * countYZ("day fyyyz") → 2
     */
    public int countYZ(String str) {
        str = str.toLowerCase();
        int len = str.length();
        int cnt = 0;
        char c;
        for (int i = 0; i < len; i++){
            c = str.charAt(i);
            if (c == 'y' || c == 'z'){
                if (i == len - 1){
                    cnt++;
                    break;
                }
                if (!Character.isLetter(str.charAt(i+1))){
                    i++;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p192570
     * Given two strings, base and remove, return a version of the base string
     * where all instances of the remove string have been removed (not case
     * sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves
     * "x".
     * 
     * withoutString("Hello there", "llo") → "He there"
     * withoutString("Hello there", "e") → "Hllo thr"
     * withoutString("Hello there", "x") → "Hello there"
     */
    public String withoutString(String base, String remove) {
        int len = base.length();
        int lenR = remove.length();
        if (len < lenR) return base;
        String lowB = base.toLowerCase();
        String lowR = remove.toLowerCase();
        String result = "";
        for (int i = 0; i < len; i++){
            if (i < len - lenR + 1 && lowR.equals(lowB.substring(i, i+lenR))){
                i+= lenR -1 ;
                continue;
            }
            result += base.charAt(i);
        }
        return result;
    }

    /** https://codingbat.com/prob/p141736
     * Given a string, return true if the number of appearances of "is" anywhere
     * in the string is equal to the number of appearances of "not" anywhere in
     * the string (case sensitive).
     * 
     * equalIsNot("This is not") → false
     * equalIsNot("This is notnot") → true
     * equalIsNot("noisxxnotyynotxisi") → true
     */
    public boolean equalIsNot(String str) {
        int cntIs = 0;
        int cntNot = 0;
        int len = str.length();
        for (int i = 0; i < len; i++){
            if (i < len - 1 && "is".equals(str.substring(i, i+2))) cntIs++;
            if (i < len - 2 && "not".equals(str.substring(i, i+3))) cntNot++;
        }
        return cntIs == cntNot;
    }

    /** https://codingbat.com/prob/p198664
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 
     * g' immediately to its left or right. Return true if all the g's in the
     * given string are happy.
     * 
     * gHappy("xxggxx") → true
     * gHappy("xxgxx") → false
     * gHappy("xxggyygxx") → false
     */
    public boolean gHappy(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'g' && !(i > 0 && str.charAt(i-1) == 'g' ||
                    i < len - 1 && str.charAt(i+1) == 'g')) {
                return false;
                }
            }
        return true;
    }

    /** https://codingbat.com/prob/p195714
     * We'll say that a "triple" in a string is a char appearing three times in
     * a row. Return the number of triples in the given string. The triples may
     * overlap.
     * 
     * countTriple("abcXXXabc") → 1
     * countTriple("xxxabyyyycd") → 3
     * countTriple("a") → 0
     */
    public int countTriple(String str) {
        str = str.toLowerCase();
        int cnt = 0;
        for (int i = 0; i < str.length() -2; i++){
            if (str.charAt(i) == str.charAt(i+1) && 
                str.charAt(i) == str.charAt(i+2)){
                cnt++;
            }
        }
        return cnt;
    }
    
    /** https://codingbat.com/prob/p197890
     * Given a string, return the sum of the digits 0-9 that appear in the
     * string, ignoring all other characters. Return 0 if there are no digits in
     * the string. (Note: Character.isDigit(char) tests if a char is one of the
     * chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an
     * int.)
     * 
     * sumDigits("aa1bc2d3") → 6
     * sumDigits("aa11b33") → 8
     * sumDigits("Chocolate") → 0
     */
    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i))) {
                sum += Character.getNumericValue(str.charAt(i));
            }
        }
        return sum;
    }

    /** https://codingbat.com/prob/p131516
     * Given a string, return the longest substring that appears at both the
     * beginning and end of the string without overlapping. For example,
     * sameEnds("abXab") is "ab".
     * 
     * sameEnds("abXYab") → "ab"
     * sameEnds("xx") → "x"
     * sameEnds("xxx") → "x"
     */
    public String sameEnds(String string) {
        String result = "";
        String sub = "";
        int len = string.length();
        for (int i = 1; i <= len / 2; i++) {
            sub = string.substring(0, i);
            if (sub.equals(string.substring(len-i))) result = sub;
        }
        return result;
    }

    /** https://codingbat.com/prob/p139411
     * Given a string, look for a mirror image (backwards) string at both the
     * beginning and end of the given string. In other words, zero or more
     * characters at the very begining of the given string, and at the very end
     * of the string in reverse order (possibly overlapping). For example, the
     * string "abXYZba" has the mirror end "ab".
     * 
     * mirrorEnds("abXYZba") → "ab"
     * mirrorEnds("abca") → "a"
     * mirrorEnds("aba") → "aba"
     */
    public String mirrorEnds(String string) {
        String result = "";
        int len = string.length();
        char cur;
        for (int i = 0; i < len; i++){
            cur = string.charAt(i);
            if (cur == string.charAt(len-1-i)) result += cur;
            else break;
        }
        return result;
    }

    /** https://codingbat.com/prob/p179479
     * Given a string, return the length of the largest "block" in the string. A
     * block is a run of adjacent chars that are the same.
     * 
     * maxBlock("hoopla") → 2
     * maxBlock("abbCCCddBBBxx") → 3
     * maxBlock("") → 0
     */
    public int maxBlock(String str) {
        int max = 0;
        int cnt = 0;
        char cur = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == cur) {
                cnt++;
                if (max < cnt) max = cnt;
            } else {
                cur = str.charAt(i);
                if (max < cnt) max = cnt;
                cnt = 1;
            }
        }
        return max;
    }

    /** https://codingbat.com/prob/p121193
     * Given a string, return the sum of the numbers appearing in the string,
     * ignoring all other characters. A number is a series of 1 or more digit
     * chars in a row. (Note: Character.isDigit(char) tests if a char is one of
     * the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to
     * an int.)
     * 
     * sumNumbers("abc123xyz") → 123
     * sumNumbers("aa11b33") → 44
     * sumNumbers("7 11") → 18
     */
    public int sumNumbers(String str) {
        int sum = 0;
        String temp = "";
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                temp += c;
                continue;
            }
            if (temp.length() > 0){
                sum += Integer.parseInt(temp);
                temp = "";
            }
        }
        if (temp.length() > 0) sum += Integer.parseInt(temp);
        return sum;
    }

    /** https://codingbat.com/prob/p154137
     * Given a string, return a string where every appearance of the lowercase
     * word "is" has been replaced with "is not". The word "is" should not be
     * immediately preceeded or followed by a letter -- so for example the "is"
     * in "this" does not count. (Note: Character.isLetter(char) tests if a char
     * is a letter.)
     * 
     * notReplace("is test") → "is not test"
     * notReplace("is-is") → "is not-is not"
     * notReplace("This is right") → "This is not right"
     */
    public String notReplace(String str) {
        int len = str.length();
        if (len < 4) return (len == 2 && str.equals("is")) ? "is not" : str;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < len - 1 && str.substring(i, i+2).equals("is")) {
                if (i == 0 && !Character.isLetter(str.charAt(i+2))){
                    result += "is not";
                    i++;
                    continue;
                }
                if (i == len -2 && !Character.isLetter(str.charAt(i-1))){
                    result += "is not";
                    i++;
                    continue;
                }
                if (i > 0 && i < len - 1 && 
                !Character.isLetter(str.charAt(i-1)) &&
                !Character.isLetter(str.charAt(i+2))) {
                    result += "is not";
                    i++;
                    continue;
                }
                result += "is";
                i++;
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
}