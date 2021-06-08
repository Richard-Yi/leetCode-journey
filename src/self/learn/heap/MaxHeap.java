package self.learn.heap;

import java.util.NoSuchElementException;

/**
 * @author Richard_yyf
 * @version 1.0 2021/6/3
 */
public class MaxHeap {



    // 用数组表示，i位置元素的左右节点为 2i, 2i+1
    // 平衡二叉树，两个子节点都小于父节点
    // 支持动态扩容

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        heap.add(1);
        heap.add(6);
        heap.add(3);
        heap.add(9);
        heap.add(10);
        heap.add(11);
        // 11
        System.out.println(heap.peek());
        // 11
        System.out.println(heap.poll());
        // 10
        System.out.println(heap.poll());
        // 9
        System.out.println(heap.poll());
        // 6
        System.out.println(heap.poll());
        // 3
        System.out.println(heap.peek());
    }

    private int size;
    private int capacity;
    private int[] arr;

    public MaxHeap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.arr = new int[initialCapacity];
    }

    // add:   将新元素插入堆
    // poll:  将根节点（数值最大的元素）删除
    // peek:  获取根节点的数值

    /*
     * 在任何的时间点，最大堆都应该保持其特性：父节点的数值比所有子节点大。在插入新元素的时候，我们要遵循以下的步骤：
     *
     * 在堆的最后新建一个节点。
     * 将数值赋予新节点。
     * 将其节点和父节点比较。
     * 如果新节点的数值比父节点大，调换父子节点的位置。
     * 重复步骤3和4直到最大堆的特性被满足。
     */

    public void add(int val) {
        if (size == capacity) {
            // 需要扩容
            int[] newArray = new int[capacity * 2];
            System.arraycopy(arr, 0, newArray, 0, size);
            arr = newArray;
            capacity = capacity * 2;
        }

        arr[size] = val;
        size++;

        heapifyUp();
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int rm = arr[0];
        arr[0] = arr[size - 1];
        size--;

        heapifyDown();
        return rm;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return arr[0];
    }

    // 由下往上
    private void heapifyUp() {
        if (size <= 1) {
            return;
        }
        // 尾节点和自己的父节点对比
        // 如果不满足最大堆的条件，即子节点 < 父节点，则调换位置
        // 直到满足子节点 < 父节点
        int i = size - 1;
        while (i > 0) {
            if (arr[(i - 1) / 2] < arr[i]) {
                // 子节点 > 父节点
                swap(arr, (i - 1) / 2, i);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

    /**
     * 由上往下
     */
    private void heapifyDown() {
        if (size <= 1) {
            return;
        }
        // 父节点和自己的子节点对比
        // 如果不满足最大堆的条件，即子节点 < 父节点，则调换位置
        // 直到满足父节点 > 子节点
        int i = 0;
        // 当i还有子节点时，如果没有就不用判断了
        while (i * 2 + 1 < size) {
            // 拿左右子节点中最大的子节点来比较
            int largerChildIndex;
            if (i * 2 + 2 < size && arr[i * 2 + 2] > arr[i * 2 + 1]) {
                // 存在右节点，且右节点 > 左节点
                largerChildIndex = i * 2 + 2;
            } else {
                largerChildIndex = i * 2 + 1;
            }

            if (arr[i] < arr[largerChildIndex]) {
                // 左子节点
                swap(arr, largerChildIndex, i);
                i = largerChildIndex;
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
