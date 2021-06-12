
## heap 和 sorting的区别

heap 常用来计算最大值和最小值，和sorting的区别在于何处呢？

![](heap-vs-sorting.png)

## 套路

- 凡是关于 `topK` 问题，都是用heap

### 最小堆
```java
PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
```

### 最大堆
```java
PriorityQueue<ListNode> maxHeap = new PriorityQueue<>((node1, node2) -> node2.val - node1.val);
```