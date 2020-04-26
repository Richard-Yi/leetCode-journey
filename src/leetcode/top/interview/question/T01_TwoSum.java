package leetcode.top.interview.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/26
 */
public class T01_TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            // 记住，一个元素只能用一次，所以这里要考虑取出来的是自己的情况
            Integer res = map.get(temp);
            if (res != null && res != i) {
                return new int[]{i, res};
            }
        }
        throw new IllegalArgumentException();
    }
}
