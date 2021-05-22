package self.learn.array.sort;

/**
 * @author Richard_yyf
 * @version 1.0 2020/7/4
 */
public class SortMethod {

    /**
     * 冒泡只会操作相邻的两个数组，每次冒泡至少让一个元素移动到它应该在的地方
     * <p>
     * 1. 原地排序算法
     * 2. 稳定排序算法，当相等是不会交换顺序
     * 3. 时间复杂度 O(n^2)
     *
     * @param nums nums
     */
    public static void bubbleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 提前退出冒泡
            boolean noDataSwap = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    noDataSwap = false;
                }
            }
            if (noDataSwap) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 插入算法思想
     * 将数组中元素分为两个区间：已排序区间和未排序区间，
     * 初始已排序区间只有1个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
     * 并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
     * </p>
     *
     * @param nums nums
     */
    public static void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 已排序部分，从后向前遍历
                if (nums[j] > val) {
                    // 移动
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = val;
        }
    }

    /**
     * 从前向后遍历，每次遍历找起始位置i上或者之后所有元素中最小的，放在位置i上
     * @param nums
     */
    public static void selectionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    int temp = nums[j];
                    nums[j] = min;
                    min = temp;
                }
            }
            nums[i] = min;
        }
    }

    // ======================  nlog(n)  ===================

    /**
     * 归并排序的核心思想还是蛮简单的。
     * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
     * 再将排好序的两部分合并在一起，这样整个数组就都有序。
     *
     * 分治是一种解决问题的处理思想，递归是一种编程技巧
     *
     * 归并排序不是原地排序算法
     *
     * @param nums nums
     */
    public static void mergeSort(int[] nums) {
        mergeOne(nums, 0, nums.length - 1);
    }

    private static void mergeOne(int[] nums, int left, int right) {
        if (left >= right) {
            // 递归截止条件
            return;
        }

        int q = (left + right) / 2;
        mergeOne(nums, left, q);
        mergeOne(nums, q + 1, right);
        // 有序段合并
        merge(nums, left, q, right);
    }

    private static void merge(int[] nums, int left, int q, int right) {
        // [left, q] [q + 1, right]
        int k = 0;
        int i = left; int j = q + 1;
        int[] tmp = new int[right - left + 1];
        while (i <= q && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        // 看下左右数组哪边剩余了
        int l, r;
        if (i == left) {
            // 剩余左边 [left, q]
            l = left; r = q;
        } else {
            // 剩余的是右边 [q+1, right]
            l = q + 1; r = right;
        }
        // copy rest
        while (l <= r) {
            tmp[k++] = nums[l++];
        }

        // copy from tmp to nums
        for (i = 0; i < tmp.length; i++) {
            nums[left + i] = tmp[i];
        }
    }

    // 归并排序并没有像快排那样，应用广泛，这是为什么呢？
    // 因为它有一个致命的“弱点”，那就是归并排序不是原地排序算法。

    /**
     * 原地排序算法
     * 但不是稳定的排序算法
     * @param nums
     */
    public static void quickSort(int[] nums) {
        quickSortInternal(nums, 0, nums.length - 1);
    }

    private static void quickSortInternal(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition2(nums, p, r);
        quickSortInternal(nums, p, q - 1);
        quickSortInternal(nums, q + 1, r);
    }

    public static int partition(int[] nums, int p, int r) {
        int val = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] < val) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    public static int partition2(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 适合内存不够，采用文件（桶）进行排序
     */
    public static void bucketSort() {

    }

    /**
     * 适合排序范围小，内存大的场景
     * @param nums
     */
    public static void countSort(int[] nums) {
        // 确认范围
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // count
        int len = max - min + 1;
        int[] count = new int[len];
        for (int num : nums) {
            count[num - min] = count[num - min] + 1;
        }
        // 累加
        int m = 0;
        for (int i = 0; i < count.length; i++) {
            m += count[i];
            count[i] = m;
        }
        // sort
        int[] tmp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = nums[i] - min;
            if (count[idx] > 0) {
                tmp[count[idx] - 1] = idx;
                count[idx] = count[idx] - 1;
            }
        }
        // copy
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }
}
