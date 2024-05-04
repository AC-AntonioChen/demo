package easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
//        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

public class No_0001 {
    // 暴力 O(n)方
//    @Test
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[]{0,1};
//    }

    // 哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[1];
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ret = twoSum(nums, target);
        System.out.println(Arrays.toString(ret));
    }
}
