package self.learn.array.binarysearch;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/14
 */
public class SearchInsert_T35 {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return Math.min(left, right) + 1;
    }
}
