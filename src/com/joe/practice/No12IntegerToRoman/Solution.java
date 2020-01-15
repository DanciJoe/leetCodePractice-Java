package com.joe.practice.No12IntegerToRoman;

/**
 * @author : Joe
 * created : 10:53 2020/1/15
 * description :整数转罗马数字
 */
public class Solution {

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
     * 12 写做 XII ，即为 X + II 。
     * 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。
     * 但也存在特例，例如 4 不写做 IIII，而是 IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 整数转罗马数字，时间复杂度O（n）
     * 贪心思想？？
     * @param num
     * @return
     */
    private static String intToRoman(int num) {
        int[] numArray = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanArray = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();
        if (num < 0 || num > 3999) {
            return null;
        }
        for (int i = 0; i < numArray.length; i++) {
            int temp = num / numArray[i];
            while (temp > 0) {
                sb.append(romanArray[i]);
                temp--;
            }
            num = num % numArray[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 490;
        System.out.println(intToRoman(num));
    }
}
