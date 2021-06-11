package self.learn.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度：mid
 * tag: hash map
 * 总结：精华 S(x->y) = S(0->y) - S(0->x)
 * @author Richard_yyf
 * @version 1.0 2021/6/11
 */
public class SubarraySum_T560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 要先放一个
        map.put(0, 1);
        for (int num : nums) {
            sum = num + sum;
            if (map.containsKey(sum - k)) {
                // 这里容易错
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
