package self.learn.array.binarysearch;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @author Richard_yyf
 * @version 1.0 2021/5/14
 */
public class BinarySearch_T704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            //[left, right]
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // [left, mid - 1]
                right = mid - 1;
            }
        }

        return -1;
    }

}
