package leetcode.self.study.lru;

/**
 * @author Richard_yyf
 * @version 1.0 2020/6/20
 */
public class LruTest {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);

        // 模拟
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        cache.get(3); // 3 应该排到最前面
        System.out.println(cache);

        cache.put(4, 4); // 会把2移除
        System.out.println(cache);
    }
}
