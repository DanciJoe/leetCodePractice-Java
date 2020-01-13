package com.joe.practice.No10RegularExpressionMatching;

/**
 * @author : Joe
 * created : 10:08 2020/1/13
 * description :正则表达式匹配
 */
public class Solution {
    /**
     * Given an input string (s) and a pattern (p),
     * implement regular expression matching with support for '.' and '*'.
     * <p>
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 回溯算法
     * @param s
     * @param p
     * @return
     */
    private static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //首先匹配第一个字符，检查是否相同或者匹配串是否以“.”开始
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String text = "ab";
        String pattern = ".*";
        System.out.println(isMatch(text,pattern));
    }
}
