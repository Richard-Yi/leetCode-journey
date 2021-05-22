package self.learn.array.sort;

import java.util.Arrays;

/**
 * @author Richard_yyf
 * @version 1.0 2021/5/22
 */
public class CountingSortSelf {

    public static void main(String[] args) {
        int[] nums = {4, 1, 6, 3, 2, 5};
        new CountingSortSelf().countingSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    // 插入排序

    public void countingSort(int[] arr) {

        if (arr.length <= 1) {
            return;
        }

        // 确认count array length
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int[] countArray = new int[max - min + 1];

        // min对应countArray下标0，下标和实际计数的对应关系，id + min = realNum
        // 遍历arr原数组计数
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min] += 1;
        }

        // 对 count array 做累加
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        // 根据 count array 累加后的结果，对原数组进行排序
        // 这里需要一个临时的数组
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 还是要注意 下标和实际元素大小的关系
            int count = countArray[arr[i] - min];
            // 小于等于 arr[i] 的有 count个，所以把 arr[i] 放在正确的位置 下标为(count - 1)
            temp[count - 1] = arr[i];
            // 计数相应减少
            countArray[arr[i] - min] = count - 1;
        }

        // copy back
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
