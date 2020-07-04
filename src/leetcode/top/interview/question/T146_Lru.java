package leetcode.top.interview.question;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Richard_yyf
 * @version 1.0 2020/5/18
 */
public class T146_Lru {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1) == 1);;       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2) == -1);;       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1) == -1);       // 返回 -1 (未找到)
        System.out.println(cache.get(3) == 3);       // 返回  3
        System.out.println(cache.get(4) == 4);       // 返回  4
    }

    static class LRUCache extends LinkedHashMap<Integer, Integer>{

        private int capacity;

        public LRUCache(int capacity) {
            // access order true -> 每一次get 操作，会把节点移到最后面
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            // 存在，更新到首尾
            return getOrDefault(key, -1);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
    }
}
