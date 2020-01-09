package com.joe.practice.No7reverseinteger;

/**
 * @author : Joe
 * created : 15:42 2020/1/9
 * description :反转一个32位的有符号整数的每一位
 */
public class Solution {
    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     * [−231,  231 − 1]. For the purpose of this problem,
     * assume that your function returns 0 when the reversed integer overflows.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 32位有符号整数的反转
     * @param x
     * @return
     */
    private static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 120;
        System.out.println(reverse(x));
    }
}
