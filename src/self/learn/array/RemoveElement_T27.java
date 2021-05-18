package self.learn.array;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/18
 */
public class RemoveElement_T27 {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        // 要点在于 nums.length - count
        for (int i = 0; i < nums.length - count;) {
            if (nums[i] == val) {
                nums[i] = nums[nums.length - 1 - count];
                nums[nums.length - 1 - count] = val;
                count++;
            } else {
                i++;
            }
        }
        return nums.length - count;
    }
}
