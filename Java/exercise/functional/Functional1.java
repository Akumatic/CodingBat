package exercise.functional;

import java.util.List;

/** https://codingbat.com/java/Functional-1
 *  Functional mapping operations on lists with lambdas. See the Java Functional
 * Mapping page for an introduction. The main computation for each of these
 * problems can be done with 1 line of lambda code.
 * https://codingbat.com/doc/java-functional-mapping.html
 */

class Functional1 {
    /** https://codingbat.com/prob/p117665
     * Given a list of integers, return a list where each integer is multiplied
     * by 2.
     * 
     * doubling([1, 2, 3]) → [2, 4, 6]
     * doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
     * doubling([]) → []
     */
    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }

    /** https://codingbat.com/prob/p139586
     * Given a list of integers, return a list where each integer is multiplied
     * with itself.
     * 
     * square([1, 2, 3]) → [1, 4, 9]
     * square([6, 8, -6, -8, 1]) → [36, 64, 36, 64, 1]
     * square([]) → []
     */
    public List<Integer> square(List<Integer> nums) {
        nums.replaceAll(n -> n * n);
        return nums;
    }

    /** https://codingbat.com/prob/p170181
     * Given a list of strings, return a list where each string has "*" added at
     * its end.
     * 
     * addStar(["a", "bb", "ccc"]) → ["a*", "bb*", "ccc*"]
     * addStar(["hello", "there"]) → ["hello*", "there*"]
     * addStar(["*"]) → ["**"]
     */
    public List<String> addStar(List<String> strings) {
        strings.replaceAll(s -> s + "*");
        return strings;
    }

    /** https://codingbat.com/prob/p181634
     * Given a list of strings, return a list where each string is replaced by 3
     * copies of the string concatenated together.
     * 
     * copies3(["a", "bb", "ccc"]) → ["aaa", "bbbbbb", "ccccccccc"]
     * copies3(["24", "a", ""]) → ["242424", "aaa", ""]
     * copies3(["hello", "there"]) → ["hellohellohello", "theretherethere"]
     */
    public List<String> copies3(List<String> strings) {
        strings.replaceAll(s -> s + s + s);
        return strings;
    }

    /** https://codingbat.com/prob/p177528
     * Given a list of strings, return a list where each string has "y" added at
     * its start and end.
     * 
     * moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
     * moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
     * moreY(["yay"]) → ["yyayy"]
     */
    public List<String> moreY(List<String> strings) {
        strings.replaceAll(s -> "y" + s + "y");
        return strings;
    }

    /** https://codingbat.com/prob/p103869
     * Given a list of integers, return a list where each integer is added to 1
     * and the result is multiplied by 10.
     * 
     * math1([1, 2, 3]) → [20, 30, 40]
     * math1([6, 8, 6, 8, 1]) → [70, 90, 70, 90, 20]
     * math1([10]) → [110]
     */
    public List<Integer> math1(List<Integer> nums) {
        nums.replaceAll(n -> (n+1) * 10);
        return nums;
    }

    /** https://codingbat.com/prob/p152194
     * Given a list of non-negative integers, return an integer list of the
     * rightmost digits. (Note: use %)
     * 
     * rightDigit([1, 22, 93]) → [1, 2, 3]
     * rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
     * rightDigit([10, 0]) → [0, 0]
     */
    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }

    /** https://codingbat.com/prob/p186894
     * Given a list of strings, return a list where each string is converted to
     * lower case (Note: String toLowerCase() method).
     * 
     * lower(["Hello", "Hi"]) → ["hello", "hi"]
     * lower(["AAA", "BBB", "ccc"]) → ["aaa", "bbb", "ccc"]
     * lower(["KitteN", "ChocolaTE"]) → ["kitten", "chocolate"]
     */
    public List<String> lower(List<String> strings) {
        strings.replaceAll(s -> s.toLowerCase());
        return strings;
    }

    /** https://codingbat.com/prob/p105967
     * Given a list of strings, return a list where each string has all its "x"
     * removed.
     * 
     * noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
     * noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
     * noX(["x"]) → [""]
     */
    public List<String> noX(List<String> strings) {
        strings.replaceAll(s -> s.replace("x", ""));
        return strings;
    }
}