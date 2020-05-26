package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/26
 */
public class T448_FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums).toString());
    }

    // 在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务
    // 假定返回的数组不算在额外空间内。

    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // 遍历，用数组下标+是否>0标记是否存在
        for (int i = 0; i < nums.length; i++) {
            // 负数代表存在过
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
