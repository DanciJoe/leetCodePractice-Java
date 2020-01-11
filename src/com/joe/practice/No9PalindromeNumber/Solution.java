package com.joe.practice.No9PalindromeNumber;

/**
 * @author : Joe
 * created : 18:03 2020/1/10
 * description :回文数
 */
public class Solution {

    /**
     * Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     * <p>
     * Follow up:
     * <p>
     * Coud you solve it without converting the integer to a string?
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 判断整数是否是回文数
     * @param x
     * @return
     */
    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x / 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    public static void main(String[] args) {
        int x = 12321;
        System.out.println(isPalindrome(x));
    }
}
