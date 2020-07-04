package leetcode.self.study.sort;

/**
 * @author Richard_yyf
 * @version 1.0 2020/7/4
 */
public class FindKthNum {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {1, 3, 4, 10};
        System.out.println(findKth(nums, k));
    }

    private static int findKth(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException();
        }

        return findKthInternal(nums, 0, nums.length - 1, k);
    }

    private static int findKthInternal(int[] nums, int r, int q, int k) {
        int p = SortMethod.partition(nums, r, q);
        if (p + 1 == k) {
            return nums[p];
        } else if (p + 1 > k) {
            // [r, p - 1]
            return findKthInternal(nums, r, p - 1, k);
        } else {
            // [p + 1, q]
            return findKthInternal(nums, p + 1, q, k);
        }
    }
}
