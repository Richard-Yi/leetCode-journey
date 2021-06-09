package self.learn.heap;

import java.util.PriorityQueue;

/**
 * 难度：medium
 * tag: 堆排序，最大堆 最小堆
 * 总结：topK 问题，都用最大堆
 * @author Richard_yyf
 * @version 1.0 2021/6/8
 */
public class FindKthLargest_T215 {

    public int findKthLargest_V2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : nums) {
            if (heap.size() < k || x >= heap.peek()) {
                heap.offer(x);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            heap[i] = nums[i];
            heapifyUp(heap, i + 1);
        }

        int size = nums.length;
        for (int i = 0; i < k - 1; i++) {
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(heap, size);
        }
        return heap[0];
    }

    private void heapifyDown(int[] nums, int size) {
        int i = 0;
        while (i * 2 + 1 < size) {
            int largerChildIndex;
            if (i * 2 + 2 < size && nums[i * 2 + 2] > nums[i * 2 + 1]) {
                largerChildIndex = i * 2 + 2;
            } else {
                largerChildIndex = i * 2 + 1;
            }

            if (nums[i] < nums[largerChildIndex]) {
                swap(nums, i, largerChildIndex);
                i = largerChildIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyUp(int[] nums, int size) {
        int i = size - 1;
        while (i > 0) {
            if (nums[i] > nums[(i - 1) / 2]) {
                swap(nums, i, (i - 1) / 2);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
