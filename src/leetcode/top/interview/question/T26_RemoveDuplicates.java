package leetcode.top.interview.question;

/**
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author Richard_yyf
 * @version 1.0 2020/3/9
 */
public class T26_RemoveDuplicates {

    // 给定 排序数组
    // 原地 删除重复出现的元素
    // 返回 移除后数组的新长度
    // 不要使用额外的数组空间；
    // O(1)额外空间
    // 你不需要考虑数组中超出新长度后面的元素

    // 双指针的题目

    public int removceDuplicate(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        // i -> 慢指针，代表唯一元素的下标
        int i = 0;
        // j -> 快指针
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                // 慢指针要动起来了
                // 慢指针i 只用自增1；因为nums[j]这个不一样的，会被提到i+1的位置
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
