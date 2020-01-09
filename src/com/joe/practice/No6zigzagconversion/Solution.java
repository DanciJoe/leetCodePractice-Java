package com.joe.practice.No6zigzagconversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Joe
 * created : 14:17 2020/1/9
 * description :Z字型变换
 */
public class Solution {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * Z字型变换
     * @param s
     * @param numRows
     * @return
     */
    private static String convert(String s, int numRows) {
        //没有拐点，按照原格式输出
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c:s.toCharArray()
             ) {
            rows.get(i).append(c);
            //如果为第一行或者最后一行执行反向，Z的拐点
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row:rows
             ) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDEFGH";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
}
