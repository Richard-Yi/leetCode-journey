package self.learn.array;

/**
 * - tag: 数组
 * - 思路很重要
 * - 难度：hard
 * @author Richard_yyf
 * @version 1.0 2021/5/29
 */
public class TrapWater_T42 {

    public int trap(int[] height) {
        int peak_i = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[peak_i]) {
                peak_i = i;
            }
        }

        int area = 0;
        // [0, peak_i)
        int i = 0;
        int leftMostBar = 0;
        while (i < peak_i) {
            if (height[i] > leftMostBar) {
                leftMostBar = height[i];
            } else {
                area += leftMostBar - height[i];
            }
            i++;
        }
        // (peak_i, height - 1]
        int rightMostBar = 0;
        int j = height.length - 1;
        while (j > peak_i) {
            if (height[j] > rightMostBar) {
                rightMostBar = height[j];
            } else {
                area += rightMostBar - height[j];
            }
            j--;
        }

        return area;
    }
}
