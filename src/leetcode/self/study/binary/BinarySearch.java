package leetcode.self.study.binary;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/27
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(nums, 6));

        int[] nums2 = {1, 2, 2, 2, 4};
        System.out.println(binarySearchLeftBoundary(nums2, 2));
        System.out.println(binarySearchLeftBoundaryUnitedVersion(nums2, 2));

        System.out.println(binarySearchRightBoundary(nums2, 2));
        System.out.println(binarySearchRightBoundaryUnitedVersion(nums2, 2));
    }

    // 二分查找要点：明确「搜索区间」这个概念

    /*
    1、为什么 while 循环的条件中是 <=，而不是 <？
    答：因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
    这二者可能出现在不同功能的二分查找中，区别是：前者相当于两端都闭区间 [left, right]，后者相当于左闭右开区间 [left, right)，因为索引大小为 nums.length 是越界的。
    我们这个算法中使用的是前者 [left, right] 两端都闭的区间。这个区间其实就是每次进行搜索的区间。
    */

    /**
     * 经典 二分法搜索 nums 如[1,2,3,4,5]
     *
     * @param nums   nums
     * @param target target
     * @return index
     */
    static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        // 注意
        int right = nums.length - 1;

        // 本算法的搜索区间是两端都闭的，即 [left, right]。
        // 那么当我们发现索引 mid 不是要找的 target 时，下一步应该去搜索哪里呢？
        // 当然是去搜索 [left, mid-1] 或者 [mid+1, right] 对不对？
        // 因为 mid 已经搜索过，应该从搜索区间中去除。

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // nums[mid] 被检测之后，下一步搜索区间就是[left, mid-1] 或者 [mid+1, right]
            // [left, mid-1]  推出 -> right = mid - 1;
            // [mid+1, right] 推出 -> left = mid + 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 注意
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 注意
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找 左边界
     * 如 nums = [1,2,2,2,3] target = 2
     * 返回左边界下标 1
     *
     * @param nums   如 nums = [1,2,2,2,3]
     * @param target target
     * @return 返回左边界下标
     */
    static int binarySearchLeftBoundary(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        // 这里为什么不 -1 呢？
        int right = nums.length;

        while (left < right) {
            // Q: 为什么是 left < right?
            // A: 因为 right = nums.length 而不是 nums.length - 1。
            // 因此每次循环的「搜索区间」是 [left, right) 左闭右开。
            int mid = (left + right) / 2;

            // 因为我们的「搜索区间」是 [left, right) 左闭右开，
            // 所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，
            // 即 [left, mid) 或 [mid + 1, right)。

            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left == nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    static int binarySearchRightBoundary(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        // [left, right) -> [left, mid) [mid + 1, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (right == 0) {
            return -1;
        }
        // 这里有一个关键，就是理解right-1
        return nums[right - 1] == target ? (right-1) : -1;
    }

    /**
     * 二分查找 左边界
     * 如 nums = [1,2,2,2,3] target = 2
     * 返回左边界下标 1
     *
     * @param nums   如 nums = [1,2,2,2,3]
     * @param target target
     * @return 返回左边界下标
     */
    static int binarySearchLeftBoundaryUnitedVersion(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        // [left, right] -> [left, mid - 1], [mid + 1, right]

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target){
                // [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return  -1;
        }
        return left;
    }

    static int binarySearchRightBoundaryUnitedVersion(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // [left, right] -> [left, mid - 1], [mid + 1, right]

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (nums[right] != target) {
            return -1;
        }

        return right;
    }
}
