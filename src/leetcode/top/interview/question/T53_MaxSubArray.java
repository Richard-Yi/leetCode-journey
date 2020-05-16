package leetcode.top.interview.question;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author Richard_yyf
 * @version 1.0 2020/5/16
 */
public class T53_MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-1, 2, -1, 4, -8};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int subMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                //  前一个子组合最大值大于0，正增益
                subMax += nums[i];
            } else {
                //  前一个子组合最大值小于0，抛弃前面的结果
                subMax = nums[i];
            }
            max = Math.max(max, subMax);
        }
        return max;
    }
}
