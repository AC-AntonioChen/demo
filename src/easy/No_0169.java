package easy;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class No_0169 {
    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    // 时间复杂度：O(n) 空间复杂度O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int curKey = 0;
        int curMaxValue = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key) > curMaxValue) {
                curKey = key;
                curMaxValue = map.get(key);
            }
        }
        return curKey;
    }
}
