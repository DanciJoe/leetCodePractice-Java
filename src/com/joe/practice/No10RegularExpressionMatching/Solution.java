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
     * @param text
     * @param pattern
     * @return
     */
    private static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        //首先匹配第一个字符，检查是否相同或者匹配串是否以“.”开始
        boolean firstMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * 动态规划算法
     * @param text
     * @param pattern
     * @return
     */
    private static boolean isMatch1(String text, String pattern) {
        if (pattern.isEmpty() || text.isEmpty()) {
            return false;
        }
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        //匹配空串，偶数位只要是*就删掉两位
        for (int i = 2; i < pattern.length(); i += 2) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (text.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }

    public static void main(String[] args) {
        String text = "aab";
        String pattern = "c*a*b";
        System.out.println(isMatch1(text,pattern));
    }
}
