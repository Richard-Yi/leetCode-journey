package leetcode.top.interview.question;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author Richard_yyf
 * @version 1.0 2020/4/25
 */
public class T11_MaxArea {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        // n >= 2
        // 左右指针
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int s = h * (j - i);
            res = Math.max(s, res);
            // 移动指针
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
