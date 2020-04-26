package leetcode.top.interview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Richard_Yi
 * @version 1.0 2020/4/26
 */
public class T15_SumOfThreeNumbers {

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        int len = nums.length;
        // n*log(n)
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 这里nums是有序数组，后面的数只会越来越大或者相等，所以大于0的情况直接略过
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                // 和之前的情况一样
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int s = nums[i] + nums[left] + nums[right];
                if (s == 0) {
                    // 这里不能直接break 因为有可能还有别的方案
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重，（别忘了这是有序数组）
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (s < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
