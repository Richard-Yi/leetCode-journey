package self.learn.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *
 * 输出: [2,2]
 *
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *
 * 输出: [4,9]
 *
 * https://www.geekxh.com/1.0.%E6%95%B0%E7%BB%84%E7%B3%BB%E5%88%97/002.html#_01%E3%80%81%E9%A2%98%E7%9B%AE%E5%88%86%E6%9E%90
 *
 * @author Richard_yyf
 * @version 1.0 2021/4/13
 */
public class TwoArraysIntersection_350 {


    public static void main(String[] args) {

        // [4,9,5]
        //[9,4,9,8,4]

//        int[] nums1 = new int[]{4,9,5};
//        int[] nums2 = new int[]{9,4,9,8,4};

        // [0,5,8,7,2,9,7,5]
        //[1,4,8,9]
        int[] nums1 = new int[]{0,5,8,7,2,9,7,5};
        int[] nums2 = new int[]{1,4,8,9};

//        System.out.println(Arrays.toString(twoArraysIntersectionUsingMap(nums1, nums2)));
        System.out.println(Arrays.toString(twoArraysIntersectionUsingDoublePoint(nums1, nums2)));
    }

    public static int[] twoArraysIntersectionUsingDoublePoint(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));
        // 4 5 9
        // 44899

        int i1 = 0, i2 = 0;
        int count = 0;
        for (;;) {
            // 谁小往前进一步，相同共进一步，走到尽头就停住
            if (nums1[i1] == nums2[i2]) {
//                System.out.println("相同：i1: " + i1 + "; i2: " + i2);
                nums1[count] = nums1[i1];
                i1++;
                i2++;
                count++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;

            }  else if (nums1[i1] < nums2[i2]) {
                i1++;

            }

//            System.out.println("i1: " + i1 + "; i2: " + i2);

            if (i2 == nums2.length) {
                break;
            }

            if (i1 == nums1.length) {
                break;
            }

        }
        int[] newResult = new int[count];
        if (count >= 0) System.arraycopy(nums1, 0, newResult, 0, count);
        return newResult;
    }

    public static int[] twoArraysIntersectionUsingMap(int[] nums1, int[] nums2) {

        // O(n)

        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            // 次数
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
               nums2[count] = nums2[i];
               map.put(nums2[i], map.get(nums2[i]) - 1);
               count++;
            }
        }


        int[] newResult = new int[count];
        for (int i = 0; i < count; i++) {
            newResult[i] = nums2[i];
        }
        return newResult;

    }


}
