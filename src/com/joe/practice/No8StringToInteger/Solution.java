package com.joe.practice.No8StringToInteger;

/**
 * @author : Joe
 * created : 17:19 2020/1/10
 * description :字符串转换整数
 */
public class Solution {
    /**
     * Implement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
     * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the integral number,
     * which are ignored and have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number,
     * or if no such sequence exists because either str is empty or it contains only whitespace characters,
     * no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     *
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param str
     * @return
     */

    /**
     * 按照上述要求字符串转换整数
     * @param str
     * @return
     */
    private static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        //去除空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        //标记整数的正负号
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        int res = 0;
        for (; i <str.length() ; i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            if (flag > 0 && res > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (flag < 0 && -res < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + ch - '0';
        }
        return res * flag;
    }

    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(myAtoi(str));
    }
}
