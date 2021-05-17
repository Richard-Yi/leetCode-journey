package self.learn.array;

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
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;

        if (l1 > l2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (l1 == 0) {
            return (l2 % 2  == 0) ? (nums2[l2 / 2] + nums2[(l2 - 1)/ 2]) / 2.0 : nums2[(l2 - 1) / 2];
        }

        int start1 = 0;
        int end1 = nums1.length; // TODO 这里没理解
        // 分界线
        int cut1, cut2;
        // 二分法，l1 <= r2, l2 <= r1 范围内
        while (start1 <= end1) {
            cut1 = (start1 + end1) / 2;
            cut2 = (l + 1) / 2 - cut1; // TODO 这里没理解
            double left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double right1 = cut1 == l1 ? Integer.MAX_VALUE : nums1[cut1];
            double right2 = cut2 == l2 ? Integer.MAX_VALUE : nums2[cut2];
            if (left2 > right1) {
                // 往右
                start1 = cut1 + 1;
            } else if (left1 > right2) {
                // 往左
                end1 = cut1 - 1;
            } else {
                // 到了
                if (l % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            }
        }
        return -1;
    }
}
