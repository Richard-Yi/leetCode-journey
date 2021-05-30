package self.learn.array.double_point;

/**
 * 移出重复元素，保留至多K位(通用解)
 * @author Richard_yyf
 * @version 1.0 2021/5/30
 */
public class RemoveKElement {

    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int i = 0; // i 左边代表的是保留的数组
        int j = 0;
        while (j < nums.length) {
            if (i < k || nums[i - k] != nums[j]) {
                // 保留的情况
                nums[i] = nums[j];
                // i移动
                i++;
            }
            j++;
        }
        return i;
    }
}
