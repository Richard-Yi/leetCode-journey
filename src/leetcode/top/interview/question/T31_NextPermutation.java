package leetcode.top.interview.question;

import java.util.Arrays;

/**
 * 下一个排列：https://leetcode-cn.com/problems/next-permutation/
 *
 * @author Richard_Yi
 * @version 1.0 2020/5/6
 */
public class T31_NextPermutation {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        Arrays.sort(nums, 1, 3);
        System.out.println(Arrays.toString(nums));
    }

    // 后面的大数和前面的小数交换
    // 1. 从后向前找第一个减小的数
    // 2. 从那个高位小数后面开始找最接近它且大于它的数
    // 3. 两者交换位置，并且将大数后面的数升序排列

    private static void nextPermutation(int[] nums) {


    }
}
