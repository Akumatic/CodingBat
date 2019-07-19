package exercise.string;

/** https://codingbat.com/java/String-2
 * Medium String problems -- 1 loop.
 * See the Java String Help document for help with strings.
 * https://codingbat.com/doc/java-string-introduction.html
 */

class String2 {
    /** https://codingbat.com/prob/p165312
     * Given a string, return a string where for every char in the original,
     * there are two chars.
     * 
     * doubleChar("The") → "TThhee"
     * doubleChar("AAbb") → "AAAAbbbb"
     * doubleChar("Hi-There") → "HHii--TThheerree"
     */
    public String doubleChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            result += str.charAt(i);
            result += str.charAt(i);
        }
        return result;
    }
    /** https://codingbat.com/prob/p147448
     * Return the number of times that the string "hi" appears anywhere in the
     * given string.
     * 
     * countHi("abc hi ho") → 1
     * countHi("ABChi hi") → 2
     * countHi("hihi") → 2
     */
    public int countHi(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length()-1; i++){
            if (str.substring(i, i+2).equals("hi")) {
                cnt++;
                i++;
            }
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p111624
     * Return true if the string "cat" and "dog" appear the same number of times
     * in the given string.
     * 
     * catDog("catdog") → true
     * catDog("catcat") → false
     * catDog("1cat1cadodog") → true
     */
    public boolean catDog(String str) {
        int cat = 0;
        int dog = 0;
        for (int i = 0; i < str.length()-2; i++){
            if (str.substring(i, i+3).equals("cat")) cat++;
            if (str.substring(i, i+3).equals("dog")) dog++;
        }
        return cat == dog;
    }

    /** https://codingbat.com/prob/p123614
     * Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
     * countCode("aaacodebbb") → 1
     * countCode("codexxcode") → 2
     * countCode("cozexxcope") → 2
     */
    public int countCode(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length()-3; i++){
            if (str.substring(i, i+2).equals("co") && str.charAt(i+3) == 'e') {
                cnt++;
                i+=3;
            }
        }
        return cnt;
    }

    /** https://codingbat.com/prob/p126880
     * Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences (in
     * other words, the computation should not be "case sensitive"). Note:
     * str.toLowerCase() returns the lowercase version of a string.
     * 
     * endOther("Hiabc", "abc") → true
     * endOther("AbC", "HiaBc") → true
     * endOther("abc", "abXabc") → true
     */
    public boolean endOther(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0 || lenB == 0) return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (lenA < lenB) {
            return a.equals(b.substring((lenB-lenA)));
        }
        return b.equals(a.substring((lenA-lenB)));
    }

    /** https://codingbat.com/prob/p136594
     * Return true if the given string contains an appearance of "xyz" where the
     * xyz is not directly preceeded by a period (.). So "xxyz" counts but
     * "x.xyz" does not.
     * 
     * xyzThere("abcxyz") → true
     * xyzThere("abc.xyz") → false
     * xyzThere("xyz.abc") → true
     */
    public boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++){
            if (str.charAt(i) == '.') {
                i++;
                continue;
            }
            if ("xyz".equals(str.substring(i, i+3))){
                return true;
            }
        }
        return false;
    }

    /** https://codingbat.com/prob/p175762
     * Return true if the given string contains a "bob" string, but where the
     * middle 'o' char can be any char.
     * 
     * bobThere("abcbob") → true
     * bobThere("b9b") → true
     * bobThere("bac") → false
     */
    public boolean bobThere(String str) {
        for (int i = 0; i < str.length()-2; i++){
            if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b') return true;
        }
        return false;
    }

    /** https://codingbat.com/prob/p134250
     * We'll say that a String is xy-balanced if for all the 'x' chars in the
     * string, there exists a 'y' char somewhere later in the string. So "xxy"
     * is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return
     * true if the given string is xy-balanced.
     * 
     * xyBalance("aaxbby") → true
     * xyBalance("aaxbb") → false
     * xyBalance("yaaxbb") → false
     */
    public boolean xyBalance(String str) {
        boolean bal = true;
        for (int i = 0; i < str.length(); i++){
            if (bal && str.charAt(i) == 'x') bal = false;
            if (!bal && str.charAt(i) == 'y') bal = true;
        }
        return bal;
    }

    /** https://codingbat.com/prob/p125185
     * Given two strings, a and b, create a bigger string made of the first char
     * of a, the first char of b, the second char of a, the second char of b,
     * and so on. Any leftover chars go at the end of the result.
     * 
     * mixString("abc", "xyz") → "axbycz"
     * mixString("Hi", "There") → "HTihere"
     * mixString("xxxx", "There") → "xTxhxexre"
     */
    public String mixString(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        String result = "";
        for (int i = 0; i < ((lenA > lenB) ? lenA : lenB); i++){
        //if (i < lenA) result += a.charAt(i);
        //if (i < lenB) result += b.charAt(i);
        if (i < lenA && i < lenB) {
            result += a.charAt(i);
            result += b.charAt(i);
            continue;
        }
        if (i < lenA){
            result += a.substring(i);
            break;
        }
        result += b.substring(i);
        break;
        }
        return result;
    }

    /** https://codingbat.com/prob/p152339
     * Given a string and an int n, return a string made of n repetitions of the
     * last n characters of the string. You may assume that n is between 0 and
     * the length of the string, inclusive.
     * 
     * repeatEnd("Hello", 3) → "llollollo"
     * repeatEnd("Hello", 2) → "lolo"
     * repeatEnd("Hello", 1) → "o"
     */
    public String repeatEnd(String str, int n) {
        String result = "";
        String substr = str.substring(str.length() - n);
        for (int i = 0; i < n; i++){
            result += substr;
        }
        return result;
    }

    /** https://codingbat.com/prob/p128796
     * Given a string and an int n, return a string made of the first n
     * characters of the string, followed by the first n-1 characters of the
     * string, and so on. You may assume that n is between 0 and the length of
     * the string, inclusive (i.e. n >= 0 and n <= str.length()).
     * 
     * repeatFront("Chocolate", 4) → "ChocChoChC"
     * repeatFront("Chocolate", 3) → "ChoChC"
     * repeatFront("Ice Cream", 2) → "IcI"
     */
    public String repeatFront(String str, int n) {
        String result = "";
        for (int i = n; i > 0; i--){
            result += str.substring(0, i);
        }
        return result;
    }

    /** https://codingbat.com/prob/p109637
     * Given two strings, word and a separator sep, return a big string made of
     * count occurrences of the word, separated by the separator string.
     * 
     * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
     * repeatSeparator("This", "And", 2) → "ThisAndThis"
     * repeatSeparator("This", "And", 1) → "This"
     */
    public String repeatSeparator(String word, String sep, int count) {
        if (count == 0) return "";
        String result = "";
        for (int i = 0; i < count -1; i++){
            result += word + sep;
        }
        return result + word;
    }

    /** https://codingbat.com/prob/p136417
     * Given a string, consider the prefix string made of the first N chars of
     * the string. Does that prefix string appear somewhere else in the string?
     * Assume that the string is not empty and that N is in the range
     * 1..str.length().
     * 
     * prefixAgain("abXYabc", 1) → true
     * prefixAgain("abXYabc", 2) → true
     * prefixAgain("abXYabc", 3) → false
     */
    public boolean prefixAgain(String str, int n) {
        int len = str.length();
        if (len < 2) return false;
        String prefix = str.substring(0, n);
        if (len == 2) return prefix.equals(str.substring(1,2));
        for (int i = n; i < len-n; i++){
            if (prefix.equals(str.substring(i, i+n))) return true;
        }
        return false;
    }

    /** https://codingbat.com/prob/p159772
     * Given a string, does "xyz" appear in the middle of the string? To define
     * middle, we'll say that the number of chars to the left and right of the
     * "xyz" must differ by at most one. This problem is harder than it looks.
     * 
     * xyzMiddle("AAxyzBB") → true
     * xyzMiddle("AxyzBB") → true
     * xyzMiddle("AxyzBBB") → false
     */
    public boolean xyzMiddle(String str) {
        int len = str.length();
        if (len < 3) return false;
        int pivot = str.length() / 2;
        if (len % 2 == 1) {
            if ("xyz".equals(str.substring(pivot-1, pivot+2))) return true;
        } else {
            if ("xyz".equals(str.substring(pivot-1, pivot+2))) return true;
            if ("xyz".equals(str.substring(pivot-2, pivot+1))) return true;
        }
        return false;
    }

    /** https://codingbat.com/prob/p129952
     * A sandwich is two pieces of bread with something in between. Return the
     * string that is between the first and last appearance of "bread" in the
     * given string, or return the empty string "" if there are not two pieces
     * of bread.
     * 
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     */
    public String getSandwich(String str) {
        int len = str.length();
        if (len < 11) return "";
        int front = -1;
        int end = -1;
        for (int i = 0; i < len - 8; i++){
            if (str.substring(i, i + 5).equals("bread")){
                front = i + 5;
                break;
            }
        }
        if (front == -1) return "";
        for (int i = len; i > front + 4; i--){
            if (str.substring(i - 5, i).equals("bread")){
                end = i - 5;
                break;
            }
        }
        return (end == -1) ? "" : str.substring(front, end);
    }

    /** https://codingbat.com/prob/p194491
     * Returns true if for every '*' (star) in the string, if there are chars
     * both immediately before and after the star, they are the same.
     * 
     * sameStarChar("xy*yzz") → true
     * sameStarChar("xy*zzz") → false
     * sameStarChar("*xa*az") → true
     */
    public boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++){
            if (str.charAt(i) == '*' && str.charAt(i-1) != str.charAt(i+1)){
            return false;
            }
        }
        return true;
    }
    
    /** https://codingbat.com/prob/p122943
     * Given a string, compute a new string by moving the first char to come
     * after the next two chars, so "abc" yields "bca". Repeat this process for
     * each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any
     * group of fewer than 3 chars at the end.
     * 
     * oneTwo("abc") → "bca"
     * oneTwo("tca") → "cat"
     * oneTwo("tcagdo") → "catdog"
     */
    public String oneTwo(String str) {
        String result = "";
        int len = str.length();
        int end = len - (len % 3);
        for (int i = 0; i < end; i+=3){
            result += str.substring(i+1, i+3);
            result += str.charAt(i);
        }
        return result;
    }

    /** https://codingbat.com/prob/p180759
     * Look for patterns like "zip" and "zap" in the string -- length-3,
     * starting with 'z' and ending with 'p'. Return a string where for all such
     * words, the middle letter is gone, so "zipXzap" yields "zpXzp".
     * 
     * zipZap("zipXzap") → "zpXzp"
     * zipZap("zopzop") → "zpzp"
     * zipZap("zzzopzop") → "zzzpzp"
     */
    public String zipZap(String str) {
        if (str.length() < 3) return str;
        String result = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'z' && i < str.length() -2 && str.charAt(i+2) == 'p'){
                result += "zp";
                i+=2;
                continue;
            }
            result += str.charAt(i);
        }
        return result;
    }
    
    /** https://codingbat.com/prob/p139564
     * Return a version of the given string, where for every star (*) in the
     * string the star and the chars immediately to its left and right are gone.
     * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
     * 
     * starOut("ab*cd") → "ad"
     * starOut("ab**cd") → "ad"
     * starOut("sm*eilly") → "silly"
     */
    public String starOut(String str) {
        int len = str.length();
        String result = "";
        for (int i = 0; i < len; i++){
            if (i > 1 && str.charAt(i - 1) == '*'){
                continue;
            }
            if (str.charAt(i) == '*'){
                i ++;
                continue;
            }
            if (i < len - 1 && str.charAt(i+1) == '*') {
                i += 2;
                continue;
            }
            result += str.charAt(i);
        }
        return result;
    }

    /** https://codingbat.com/prob/p170829
     * Given a string and a non-empty word string, return a version of the
     * original String where all chars have been replaced by pluses ("+"),
     * except for appearances of the word string which are preserved unchanged.
     * 
     * plusOut("12xy34", "xy") → "++xy++"
     * plusOut("12xy34", "1") → "1+++++"
     * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
     */
    public String plusOut(String str, String word) {
        String result = "";
        int len = str.length();
        int lenW = word.length();
        for (int i = 0; i < len; i++){
            if (i <= len - lenW && str.substring(i, i + lenW).equals(word)) {
                result += word;
                i+= lenW - 1;
                continue;
            }
            result += "+";
        }
        return result;
    }

    /** https://codingbat.com/prob/p147538
     * Given a string and a non-empty word string, return a string made of each
     * char just before and just after every appearance of the word in the
     * string. Ignore cases where there is no char before or after the word, and
     * a char may be included twice if it is between two words.
     * 
     * wordEnds("abcXY123XYijk", "XY") → "c13i"
     * wordEnds("XY123XY", "XY") → "13"
     * wordEnds("XY1XY", "XY") → "11"
     */
    public String wordEnds(String str, String word) {
        String result = "";
        int len = str.length();
        int lenW = word.length();
        for (int i = 0; i < len - lenW +1; i++){
            if (str.substring(i, i + lenW).equals(word)) {
                if (i > 0) result += str.charAt(i-1);
                if (i < len - lenW) result += str.charAt(i+lenW);
            }
        }
        return result;
    }
}