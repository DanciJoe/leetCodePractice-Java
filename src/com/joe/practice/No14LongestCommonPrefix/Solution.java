package com.joe.practice.No14LongestCommonPrefix;

/**
 * @author : Joe
 * created : 15:16 2020/1/18
 * description :查找字符串数组最长公共前缀
 */
public class Solution {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    /**
     * 水平扫描方法，时间复杂度O（S），S为每个字符串的长度之和
     * @param strings
     * @return
     */
    private static String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 加入数组的末尾有一个非常短的字符串，使用上面的水平扫描的话依然会进行S次比较
     * 优化：从前往后枚举字符串的每一列，先比较每个字符串相同列的字符，然后再进行下一列的比较
     * @param strings
     * @return
     */
    private static String longestCommonPrefix1(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        for (int i = 0; i < strings[0].length(); i++) {
            char c = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++) {
                if (i == strings[j].length() || strings[j].charAt(i) != c) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[0];
    }

    public static void main(String[] args) {
        String[] strings = {"leet", "leetcode", "leets", "leeds"};
        System.out.println(longestCommonPrefix1(strings));
    }
}
