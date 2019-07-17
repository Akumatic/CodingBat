package exercise.warmup;
public class WarmUp1 {
    /** https://codingbat.com/prob/p187868 
     * The parameter weekday is true if it is a weekday, and the parameter
     * vacation is true if we are on vacation. We sleep in if it is not a
     * weekday or we're on vacation. Return true if we sleep in.
     * 
     * sleepIn(false, false) → true
     * sleepIn(true, false) → false
     * sleepIn(false, true) → true
    */ 
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
    
    
    /** https://codingbat.com/prob/p181646
     * We have two monkeys, a and b, and the parameters aSmile and bSmile
     * indicateif each is smiling. We are in trouble if they are both smiling
     * or if neither of them is smiling. Return true if we are in trouble.
     * 
     * monkeyTrouble(true, true) → true
     * monkeyTrouble(false, false) → true
     * monkeyTrouble(true, false) → false
    */
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return !(aSmile ^ bSmile);
    }
    
    
   /** https://codingbat.com/prob/p154485
    * Given two int values, return their sum. Unless the two values are the
    * same, then return double their sum.

    * sumDouble(1, 2) → 3
    * sumDouble(3, 2) → 5
    * sumDouble(2, 2) → 8
   */
    public int sumDouble(int a, int b) {
        return (a == b) ? 4*a : a + b;
    }

    /** https://codingbat.com/prob/p116624
     * Given an int n, return the absolute difference between n and 21, except
     * return double the absolute difference if n is over 21.
     * 
     * diff21(19) → 2
     * diff21(10) → 11
     * diff21(21) → 0
    */
    public int diff21(int n) {
        int d = n - 21;
        if (d < 0) d = -d;
        return (n > 21) ? 2*d : d;
    }

    /** https://codingbat.com/prob/p140449
     * We have a loud talking parrot. The "hour" parameter is the current hour
     * time in the range 0..23. We are in trouble if the parrot is talking and
     * the hour is before 7 or after 20. Return true if we are in trouble.
     * 
     * parrotTrouble(true, 6) → true
     * parrotTrouble(true, 7) → false
     * parrotTrouble(false, 6) → false
    */
    public boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour > 20 || hour < 7);
    }
    
    /** https://codingbat.com/prob/p182873
     * Given 2 ints, a and b, return true if one if them is 10 or if their sum
     * is 10.
     * 
     * makes10(9, 10) → true
     * makes10(9, 9) → false
     * makes10(1, 9) → true
    */
    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a+b == 10;
    }
    /** https://codingbat.com/prob/p184004
     * Given an int n, return true if it is within 10 of 100 or 200. 
     * Note: Math.abs(num) computes the absolute value of a number.
     * 
     * nearHundred(93) → true
     * nearHundred(90) → true
     * nearHundred(89) → false
    */
    public boolean nearHundred(int n) {
        float val = n / 100.f;
        return (val <= 1.1f && val >= 0.9f) || (val <= 2.1f && val >= 1.9f);
    }
      
    /** https://codingbat.com/prob/p159227
     * Given 2 int values, return true if one is negative and one is positive. 
     * Except if the parameter "negative" is true, then return true only if
     * both are negative.
     * posNeg(1, -1, false) → true
     * posNeg(-1, 1, false) → true
     * posNeg(-4, -5, true) → true
     */
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative){
            return a < 0 && b < 0;
        }
        return (a < 0) ^ (b < 0);
    }

    /** https://codingbat.com/prob/p191914
     * Given a string, return a new string where "not " has been added to the
     * front. However, if the string already begins with "not", return the
     * string unchanged. Note: use .equals() to compare 2 strings.
     * 
     * notString("candy") → "not candy"
     * notString("x") → "not x"
     * notString("not bad") → "not bad"
     */
    public String notString(String str) {
        if (str.split(" ")[0].equals("not")){
            return str;
        }
        return "not " + str;
    }

    /**https://codingbat.com/prob/p190570
     * Given a non-empty string and an int n, return a new string where the
     * char at index n has been removed. The value of n will be a valid index
     * of a char in the original string (i.e. n will be in the range 
     * 0..str.length()-1 inclusive).
     * 
     * missingChar("kitten", 1) → "ktten"
     * missingChar("kitten", 0) → "itten"
     * missingChar("kitten", 4) → "kittn"
     */
    public String missingChar(String str, int n) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            if (i == n) continue;
            result += str.charAt(i);
        }
        return result;
    }

    /** https://codingbat.com/prob/p123384
     * Given a string, return a new string where the first and last chars have
     * been exchanged.
     * 
     * frontBack("code") → "eodc"
     * frontBack("a") → "a"
     * frontBack("ab") → "ba"
     */
    public String frontBack(String str) {
        int len = str.length();
        if (len < 2) return str;
        return str.charAt(len-1) + str.substring(1, len-1) + str.charAt(0);
    }

    /** https://codingbat.com/prob/p136351
     * Given a string, we'll say that the front is the first 3 chars of the
     * string. If the string length is less than 3, the front is whatever is
     * there. Return a new string which is 3 copies of the front.
     * 
     * front3("Java") → "JavJavJav"
     * front3("Chocolate") → "ChoChoCho"
     * front3("abc") → "abcabcabc"
     */
    public String front3(String str) {
        String front = (str.length() < 3) ? str : str.substring(0,3);
        return front + front + front;
        
    }

    /** https://codingbat.com/prob/p161642
     * Given a string, take the last char and return a new string with the last
     * char added at the front and back, so "cat" yields "tcatt". The original
     * string will be length 1 or more.
     * 
     * backAround("cat") → "tcatt"
     * backAround("Hello") → "oHelloo"
     * backAround("a") → "aaa"
     */
    public String backAround(String str) {
        char c = str.charAt(str.length() -1);
        return c + str + c;
    }

    /** https://codingbat.com/prob/p112564
     * Return true if the given non-negative number is a multiple of 3 or a 
     * multiple of 5. Use the % "mod" operator
     * 
     * or35(3) → true
     * or35(10) → true
     * or35(8) → false
     */
    public boolean or35(int n) {
        return n % 3 == 0 || n % 5 == 0;
    }

    /** https://codingbat.com/prob/p183592
     * Given a string, take the first 2 chars and return the string with the 2 
     * chars added at both the front and back, so "kitten" yields"kikittenki".
     * If the string length is less than 2, use whatever chars are there.
     * 
     * front22("kitten") → "kikittenki"
     * front22("Ha") → "HaHaHa"
     * front22("abc") → "ababcab"
     */
    public String front22(String str) {
        String front = (str.length() < 2) ? str : str.substring(0,2);
        return front + str + front;
    }

    /** https://codingbat.com/prob/p191022
     * Given a string, return true if the string starts with "hi" and false
     * otherwise.
     * 
     * startHi("hi there") → true
     * startHi("hi") → true
     * startHi("hello hi") → false
     */
    public boolean startHi(String str) {
        if (str.length() < 2) return false;
        return str.substring(0,2).equals("hi");
    }
      
    /** https://codingbat.com/prob/p192082
     * Given two temperatures, return true if one is less than 0 and the other
     * is greater than 100.
     * 
     * icyHot(120, -1) → true
     * icyHot(-1, 120) → true
     * icyHot(2, 120) → false
     */
    public boolean icyHot(int temp1, int temp2) {
        if (temp1 < temp2) {
            return temp1 < 0 && temp2 > 100;
        }
        return temp2 < 0 && temp1 > 100;
    }
    
    /** https://codingbat.com/prob/p144535
     * Given 2 int values, return true if either of them is in the range 
     * 10..20 inclusive.
     * 
     * in1020(12, 99) → true
     * in1020(21, 12) → true
     * in1020(8, 99) → false
     */
    public boolean in1020(int a, int b) {
        if (a >= 10 && a <= 20) return true;
        if (b >= 10 && b <= 20) return true;
        return false;
    }

    /** https://codingbat.com/prob/p178986 
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
     * Given 3 int values, return true if 1 or more of them are teen.
     * 
     * hasTeen(13, 20, 10) → true
     * hasTeen(20, 19, 10) → true
     * hasTeen(20, 10, 13) → true
    */
    public boolean hasTeen(int a, int b, int c) {
        if (a >= 13 && a <= 19) return true;
        if (b >= 13 && b <= 19) return true;
        if (c >= 13 && c <= 19) return true;
        return false;
    }

    /** https://codingbat.com/prob/p165701
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
     * Given 2 int values, return true if one or the other is teen, but not both.
     * 
     * loneTeen(13, 99) → true
     * loneTeen(21, 19) → true
     * loneTeen(13, 13) → false
     */
    public boolean loneTeen(int a, int b) {
        return (a >= 13 && a <= 19) ^ (b >= 13 && b <= 19);
    }
    
    /** https://codingbat.com/prob/p100905
     * Given a string, if the string "del" appears starting at index 1, return
     * a string where that "del" has been deleted. Otherwise, return the string
     * unchanged.
     * 
     * delDel("adelbc") → "abc"
     * delDel("adelHello") → "aHello"
     * delDel("adedbc") → "adedbc"
     */
    public String delDel(String str) {
        if ((str.length() < 4) || !(str.substring(1,4).equals("del"))) return str;
        return str.charAt(0) + str.substring(4, str.length());
    }
    
    /** https://codingbat.com/prob/p151713
     * Return true if the given string begins with "mix", except the 'm' can be
     * anything, so "pix", "9ix" .. all count.
     */
    public boolean mixStart(String str) {
        if (str.length() < 3) return false;
        return str.substring(1,3).equals("ix");
    }
    
    /** https://codingbat.com/prob/p199720
     * Given a string, return a string made of the first 2 chars (if present),
     * however include first char only if it is 'o' and include the second
     * only if it is 'z', so "ozymandias" yields "oz".
     * 
     * startOz("ozymandias") → "oz"
     * startOz("bzoo") → "z"
     * startOz("oxx") → "o"
     */
    public String startOz(String str) {
        String result = "";
        if (str.length() > 0 && str.charAt(0) == 'o') {
            result += "o";
        }
        if (str.length() > 1 && str.charAt(1) == 'z') {
            result += "z";
        }
        return result;
    }
    
    /** https://codingbat.com/prob/p101887
     * Given three int values, a b c, return the largest.
     * 
     * intMax(1, 2, 3) → 3
     * intMax(1, 3, 2) → 3
     * intMax(3, 2, 1) → 3
     */
    public int intMax(int a, int b, int c) {
        int max = (b > c) ? b : c;
        return (a > max) ? a : max;
    }

    /** https://codingbat.com/prob/p172021
     * Given 2 int values, return whichever value is nearest to the value 10,
     * or return 0 in the event of a tie. Note that Math.abs(n) returns the
     * absolute value of a number.
     */
    public int close10(int a, int b) {
        int difA = a - 10;
        if (difA < 0) difA = -difA;
        int difB = b - 10;
        if (difB < 0) difB = -difB;
    return (difA == difB) ? 0 : (difA < difB) ? a : b;
    }

    /** https://codingbat.com/prob/p132134
     * Given 2 int values, return true if they are both in the range 30..40
     * inclusive, or they are both in the range 40..50 inclusive.
     */
    public boolean in3050(int a, int b) {
        if (a >= 30 && a <= 40 && b >= 30 && b <= 40) return true;
        if (a >= 40 && a <= 50 && b >= 40 && b <= 50) return true;
        return false;
    }
      
    /** https://codingbat.com/prob/p177372
     * Given 2 positive int values, return the larger value that is in the
     * range 10..20 inclusive, or return 0 if neither is in that range.
     */
    public int max1020(int a, int b) {
        boolean inRangeA = a >= 10 && a <= 20;
        boolean inRangeB = b >= 10 && b <= 20;
        if (inRangeA && !inRangeB) return a;
        if (!inRangeA && inRangeB) return b;
        if (inRangeA && inRangeB) return (a > b) ? a : b;
        return 0;   
    }
    
    /** https://codingbat.com/prob/p173784
     * Return true if the given string contains between 1 and 3 'e' chars.
     * 
     * stringE("Hello") → true
     * stringE("Heelle") → true
     * stringE("Heelele") → false
     */
    public boolean stringE(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
          if (str.charAt(i) == 'e') cnt++;
        }
        return cnt > 0 && cnt < 4;
    }

    /** https://codingbat.com/prob/p125339
     * Given two non-negative int values, return true if they have the same
     * last digit, such as with 27 and 57. Note that the % "mod" operator
     * computes remainders, so 17 % 10 is 7.
     */
    public boolean lastDigit(int a, int b) {
        return a % 10 == b % 10;
    }

    /** https://codingbat.com/prob/p125268
     * Given a string, return a new string where the last 3 chars are now in
     * upper case. If the string has less than 3 chars, uppercase whatever is
     * there. Note that str.toUpperCase() returns the uppercase version of a
     * string.
     * 
     * endUp("Hello") → "HeLLO"
     * endUp("hi there") → "hi thERE"
     * endUp("hi") → "HI"
     */
    public String endUp(String str) {
        if (str.length() < 3) return str.toUpperCase();
        return str.substring(0, str.length() - 3) +
        str.substring(str.length()-3, str.length()).toUpperCase();
    }

    /** https://codingbat.com/prob/p196441
     * Given a non-empty string and an int N, return the string made starting
     * with char 0, and then every Nth char of the string. So if N is 3, use
     * char 0, 3, 6, ... and so on. N is 1 or more.
     */
    public String everyNth(String str, int n) {
        String result = "";
        for (int i  = 0; i < str.length(); i+=n){
            result += str.charAt(i);
        }
        return result;
    }
}