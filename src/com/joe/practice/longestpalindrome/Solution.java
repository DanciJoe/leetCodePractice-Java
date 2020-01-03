package com.joe.practice.longestpalindrome;

/**
 * @author : Joe
 * created : 11:27 2020/1/3
 * description :最长回文子串
 */
public class Solution {

    /**
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerExpand(s, i, i);
            int len2 = centerExpand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    /**
     * 中心扩展
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int centerExpand(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }



    public static void main(String[] args) {
        String s = "bbb";
        System.out.println(longestPalindrome(s));
    }
}
