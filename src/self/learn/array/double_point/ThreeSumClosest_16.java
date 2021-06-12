package self.learn.array.double_point;

import java.util.Arrays;

/**
 * tag: 双指针
 * 总结：双指针的题目很重要的一点就是弄清楚指针移动的时机
 * 难度：mid
 * @author Richard_yyf
 * @version 1.0 2021/6/12
 */
public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) > Math.abs(tmp - target)) {
                    sum = tmp;
                }
                if (tmp > target) {
                    right--;
                } else if (tmp < target){
                    left++;
                } else {
                    return tmp;
                }
            }
        }
        return sum;
    }
}
