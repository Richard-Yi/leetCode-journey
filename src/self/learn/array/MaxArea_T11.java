package self.learn.array;

/**
 * 11. 盛最多水的容器
 * - tag: 双指针 数组
 * - 典型的双指针反向
 * - 难度：medium
 * @author Richard_yyf
 * @version 1.0 2021/5/29
 */
public class MaxArea_T11 {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            // height小，哪边进一步
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
