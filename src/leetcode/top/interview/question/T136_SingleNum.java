package leetcode.top.interview.question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/21
 */
public class T136_SingleNum {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    // 不使用额外空间

    static int singleNumber2(int[] nums) {

        Arrays.sort(nums);

        int pre = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {

                    return nums[i];
                }
            } else {

                if (nums[i] != pre && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            pre = nums[i];
        }

        return nums[nums.length - 1];
    }

    static int singleNumber(int[] nums) {
        Set<Integer> multiSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                multiSet.add(num);
                continue;
            }
            if (multiSet.contains(num)) {
                continue;
            }
            set.add(num);
        }
        return (int) (set.toArray())[0];
    }
}
