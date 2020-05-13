
## 算法思维

## 动态规划

- **动态规划问题的一般形式就是求最值**
- **求解动态规划的核心问题是穷举**

- 动态规划的穷举有点特别，因为这类问题**存在「重叠子问题」**，如果暴力穷举的话效率会极其低下，所以需要备忘录或者DP table来优化不必要的计算
- 动态规划问题一定会**具备「最优子结构」**，才能通过子问题的最值得到原问题的最值

动态规划三要素：

- **重叠子问题**
- **最优子结构**
- **状态转移方程**

在实际的算法问题中，**写出状态转移方程是最困难的**，思路：

> 明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case



### 例题：斐波那契数列

关键词：递归；自顶向下，自底向上；备忘录（DP table）



```java
	private static int fib3(int N) {
        if (N < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(N);
        return help(map, N);
    }
	// 带备忘录的递归
    private static int help(Map<Integer, Integer> map, int N) {

        if (N == 1 || N == 2) {
            return 1;
        }

        if (map.containsKey(N)) {
            return map.get(N);
        }

        return help(map, N - 1) + help(map, N - 2);
    }

    // DP table 自底向上推断
    private static int fib4(int N) {
        Map<Integer, Integer> map = new HashMap<>(N);

        map.put(1, 1);
        map.put(0, 0);
        for (int i = 2; i <= N; i++) {
            int ret = map.get(i - 1) + map.get(i - 2);
            map.put(i, ret);
        }
        return map.get(N);
    }

	// 
```

引出「状态转移方程」这个名词，实际上就是**描述问题结构的数学形式**：

<img src="http://img.ricstudio.top/blog/20200512203950.png" style="zoom: 25%;" />

>  **千万不要看不起暴力解，动态规划问题最困难的就是写出状态转移方程**



### 例题：凑零钱

**要符合「最优子结构」，子问题间必须互相独立**。

> 举例：
>
> 比如说，你的原问题是考出最高的总成绩，那么你的子问题就是要把语文考到最高，数学考到最高…… 为了每门课考到最高，你要把每门课相应的选择题分数拿到最高，填空题分数拿到最高…… 当然，最终就是你每门课都是满分，这就是最高的总成绩。
>
> 得到了正确的结果：最高的总成绩就是总分。因为这个过程符合最优子结构，“每门科目考到最高”这些子问题是互相独立，互不干扰的。
>
> 但是，如果加一个条件：你的语文成绩和数学成绩会互相制约，此消彼长。这样的话，显然你能考到的最高总成绩就达不到总分了，按刚才那个思路就会得到错误的结果。因为子问题并不独立，语文数学成绩无法同时最优，所以最优子结构被破坏。

**如何写出正确的状态转移方程？**

1. 先确定“状态”
2. 然后确定`dp`函数的定义
3. 然后确定“选择”并择优
4. 最后明确 base case



**备忘录、DP table 就是在追求“如何聪明地穷举”。用空间换时间的思路，是降低时间复杂度的不二法门。**

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

- **二分查找变题：搜索旋转排序数组**



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

