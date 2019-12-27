package com.joe.practice.twosum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : Joe
 * created : 17:24 2019/12/26
 * description :两数之和
 */
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int[] twoSum(int[] nums, int target){
        //1、初始化返回数组，存放的是相加起来和为target的两个元素的下标
        int[] array = new int[2];
        //2、构造HashMap以键值对存放target-nums[i]和索引下标值
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++){
            //4、如果map中存在key为下一个元素值的映射值，则取出索引值，跳出循环
            if (map.containsKey(nums[i])){
                array[0] = i;
                array[1] = map.get(nums[i]);
                return array;
            }
            //3、循环遍历数组，从第一个元素开始，将target与元素值的差值作为key，元素下表作为value存入map
            map.put(target - nums[i], i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
