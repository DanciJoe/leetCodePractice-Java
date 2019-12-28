package com.joe.practice.findmedian;

import java.util.Arrays;

/**
 * @author : Joe
 * created : 9:35 2019/12/28
 * description :寻找两个有序数组的中位数
 */
public class Solution {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 寻找两个有序数组的中位数，要求时间复杂度为O(log (m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2){
        //TODO 时间复杂度为O（log(m+n)）的算法
        return 0;
    }

    /**
     * 按照合并两个数组的解法办法，时间复杂度 m + n
     * @param nums1
     * @param nums2
     * @return
     */
    private static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        //合并后的数组的下标
        int index = 0;
        for (int value : nums1) {
            array[index] = value;
            index++;
        }
        for (int value : nums2) {
            array[index] = value;
            index++;
        }
        Arrays.sort(array);
        return findMedian(array);
    }

    private static double findMedian(int[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            int i = (array.length / 2) - 1;
            int j = array.length / 2;
            return (double) (array[i] + array[j]) / 2;
        }
        int index = array.length / 2;
        return array[index];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays1(nums1,nums2));
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        System.out.println(findMedianSortedArrays1(array1,array2));
    }
}
