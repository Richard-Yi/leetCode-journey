package leetcode.top.interview.question;

/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author Richard_Yi
 * @version 1.0 2020/5/7
 */
public class T33_SearchRotateSortedArray {

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
        System.out.println(search2(nums, 0));
    }

    // 刚开始的思路是对的，但是没考虑到只需要做一次二分法

    // 可以使用尾元素作为区分值，二分中点对应的值比尾元素小的话那就说明二分中点是在后面的区间，大的话就会是在前面的区间。
    //
    // 如果中点在后面的区间，那我们就要移动尾指针，如果是在前面的区间的话，我们就要移动首指针，其实就是逐步逼近后区间首元素的一个过程。

    private static int search2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;

        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                res = mid;
                break;
            }

            if (nums[left] <= nums[mid]) {
                // 这里代表前半部分是有序的
                if (target >= nums[left] && target < nums[mid]) {
                    // target in [left, mid)
                    right = mid - 1;
                } else {
                    // target in (mid, right]
                    left = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target <= nums[right] && target > nums[mid]) {
                    // target in (mid, right]
                    left = mid + 1;
                } else {
                    // target in [left, mid)
                    right = mid - 1;
                }
            }
        }

        return res;
    }

    private static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int tail = nums[nums.length - 1];

        if (target == tail) {
            return nums.length - 1;
        }

        int top = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;
        // [0, len - 1] -> [0, mid - 1] [mid + 1, len - 1]

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // 不能重复，所以不可能有相等的情况
            if (nums[mid] > tail) {
                // 向右搜索还有没有比它大的
                top = mid;
                left = mid + 1;
            } else if (nums[mid] < tail) {
                // 向左搜索比它大的
                right = mid - 1;
            }
        }

        int res = -1;
        if (target > tail) {
            // 搜索区间 [0, top]
            left = 0;
            right = top;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > target) {
                    // [0, mid - 1]

                    right = mid - 1;
                } else if (nums[mid] == target) {

                    res = mid;
                    break;
                } else if (nums[mid] < target) {

                    left = mid + 1;
                }
            }

        } else if (target < tail) {
            // 搜索区间 [top + 1, len - 1]

            // 搜索区间 [0, top]
            left = top + 1;
            right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > target) {
                    // [0, mid - 1]

                    right = mid - 1;
                } else if (nums[mid] == target) {

                    res = mid;
                    break;
                } else if (nums[mid] < target) {

                    left = mid + 1;
                }
            }
        }

        return res;
    }
}
