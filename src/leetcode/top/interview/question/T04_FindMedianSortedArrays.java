package leetcode.top.interview.question;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author Richard_yyf
 * @version 1.0 2020/3/24
 */
public class T04_FindMedianSortedArrays {

    public static void main(String[] args) {

    }

    // 可以简化成找在两个数组中，找第K小的数字或者(第K+第K+1小)/2

    // 看时间复杂度要求，很容易联想到二分法

    // 另外注意到是有序数组

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0;
        int left2 = 0;


        while (left1 < nums1.length && left2 < nums2.length) {

        }

        return 1;
    }
}
