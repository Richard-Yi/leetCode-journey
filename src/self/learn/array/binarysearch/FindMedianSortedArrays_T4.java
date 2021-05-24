package self.learn.array.binarysearch;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/17
 */
public class FindMedianSortedArrays_T4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println("real:" + findMedianSortedArrays(nums1, nums2));
        System.out.println("expected: " + 2.5);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));
        System.out.println("expected: " + 2.5);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println("expected: " + 1);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
        System.out.println("expected: " + 2.5);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3}));
        System.out.println("expected: " + 2);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println("expected: " + 1);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4, 5, 6, 7}));
        System.out.println("expected: " + 4);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
        System.out.println("expected: " + -1);
        System.out.println("================================");
        System.out.println("real:" + findMedianSortedArrays(new int[]{-1,4}, new int[]{1, 2, 3, 5,6}));
        System.out.println("expected: " + 3);
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2] + nums2[(len2 - 1) / 2]) / 2.0;
            } else {
                return nums2[len2 / 2];
            }
        }

        int len = len2 + len1;
        int start = 0;
        int end = len1; // 懂了，因为是代表partition,而不是那个Index
        int partition1;
        int partition2;
        while (start <= end) {
            // 确定分割线位置
            partition1 = (start + end) / 2;
            partition2 = (len + 1) / 2 - partition1;
            // 计算分割线两边的值用于二分法结果条件判断
            double left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            double left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            double right1 = partition1 == len1 ? Integer.MAX_VALUE : nums1[partition1];
            double right2 = partition2 == len2 ? Integer.MAX_VALUE : nums2[partition2];
            if (left1 > right2) {
                // partition1 需要往左移动，让left1变小
                // 数组1的分割线要往左移动
                end = partition1 - 1;
            } else if (right1 < left2) {
                // partition2 需要往右移动，让right1变大
                // 数组1的分割线要往右移动
                start = partition1 + 1;
            } else {
                if (len % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            }
        }

        return -1;
    }
}
