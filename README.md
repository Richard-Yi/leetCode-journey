
## 算法思维

### 回溯算法

**回溯算法模板**

```java
    void backTrack(路径, 选择列表) {
        // 触发结束条件
        if(stop condition) {
            // do sth
            return;
        }

        // 遍历选择列表
        for 选择 in 选择列表 {
            // 排序不合法选择
            // 更新选择列表
            // 做选择
            路径.add(选择);

            backTrack(路径, 选择列表);
            // 撤销选择
            路径.remove(选择);
            // 选择列表更新
        }
    }
```

> 练习题：题22/17/39/46/78



### 二分查找

> 题目类型：经典二分查找、二分查找左边界、二分查找右边界

- **二分查找要点：明确「搜索区间」这个概念**

具体见`leetcode.self.study.binary.BinarySearch`类中的案例。



### 双指针



### 滑动窗口

```java
String s, String t;

int left = 0, right = 0;

while (right < s.size()) {
    window.add(s[right]);
    // TODO...
    
    right++;
    
    while(valid) {
        // TODO...
        window.remove(s.[left]);
        left++;
    }
}
```

> 练习题：题03/438/76

