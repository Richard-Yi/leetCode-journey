package leetcode.top.interview.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard_Yi
 * @version 1.0 2020/5/22
 */
public class T169_MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int prev = nums[0];
        // TODO 比较简单，这里就不写了
        return prev;
    }

    static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int target = nums.length / 2;
        for (int num : nums) {
            int c = map.getOrDefault(num, 0) + 1;
            if (c > target) {
                return num;
            }
            map.put(num, c);
        }
        throw new IllegalArgumentException();
    }
}
