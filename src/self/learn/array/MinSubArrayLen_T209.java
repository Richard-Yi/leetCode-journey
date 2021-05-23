package self.learn.array;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/23
 */
public class MinSubArrayLen_T209 {

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_T209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minWindowLen = Integer.MAX_VALUE;
        int windowToTal = nums[0];

        while (true) {
            if (windowToTal < target) {
                if (right == nums.length - 1) {
                    break;
                }
                // right 右移
                right++;
                windowToTal += nums[right];
            } else {
                // 满足条件
                minWindowLen = Math.min(minWindowLen, right - left + 1);
                // left 右移，right不变
                left++;
                windowToTal -= nums[left - 1];
            }
        }

        return minWindowLen == Integer.MAX_VALUE ? 0 : minWindowLen;
    }
}
