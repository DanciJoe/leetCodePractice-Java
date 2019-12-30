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
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 在两个有序数组中找第K大的数
     * @param nums1
     * @param start1
     * @param nums2
     * @param start2
     * @param k
     * @return
     */
    private static int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        //特殊情况1：数组查找起始长度大于等于数组的长度，数组已经被淘汰
        if (start1 > nums1.length - 1) {
            return nums2[start2 + k - 1];
        }
        if (start2 > nums2.length - 1) {
            return nums1[start1 + k - 1];
        }
        //特殊情况2：查找第一个数，找两个数组起始位置中最小的那个
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int nums1Mid = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int nums2Mid = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (nums1Mid < nums2Mid) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
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
        /*int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays1(nums1,nums2));*/
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        System.out.println(findMedianSortedArrays(array1,array2));
    }
}
