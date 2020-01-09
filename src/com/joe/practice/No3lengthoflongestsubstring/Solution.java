package com.joe.practice.No3lengthoflongestsubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Joe
 * created : 10:52 2019/12/27
 * description :无重复字符的最长子串
 */
public class Solution {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 计算无重复字符的最长的子字符串的长度
     * @param s
     * @return
     */
    private static int lengthOfLongestSubString(String s){
        if (s != null && s.length() > 0){
            List<String> stringList = new ArrayList<>();
            List<String> longestList = new ArrayList<>();
            int i = 0;
            for (; i < s.length(); i++) {
                if (stringList.contains(String.valueOf(s.charAt(i)))) {
                    if (stringList.size() > longestList.size()){
                        longestList.clear();
                        longestList.addAll(stringList);
                    }
                    s = s.substring(s.indexOf(String.valueOf(s.charAt(i)))+1);
                    i = -1;
                    stringList.clear();
                    continue;
                }
                stringList.add(String.valueOf(s.charAt(i)));
            }
            if (stringList.size() > longestList.size()){
                longestList.clear();
                longestList.addAll(stringList);
            }
            return longestList.size();
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "dxdv";
        System.out.println(lengthOfLongestSubString(s));
    }
}
