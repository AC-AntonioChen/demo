package normal;

import org.junit.Test;

public class No_0080 {
    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int length = removeDuplicates(nums);
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[slow - 2] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow;
    }


    public int removeDuplicatesOfFirstTry(int[] nums) {
        // 当前数组实际的长度
        int actualLength = nums.length;
        // 当前缓存的数字，如果计数超过2，则去除该数字
        int cachedNum = 0;
        int cachedNumCount = 0;
        for (int leftPointer = 0; leftPointer < actualLength; leftPointer++) {
            // 初始化
            if (leftPointer == 0) {
                cachedNum = nums[leftPointer];
                cachedNumCount++;
                continue;
            }

            // 重置计数
            if (nums[leftPointer] != cachedNum) {
                cachedNum = nums[leftPointer];
                cachedNumCount = 1;
                continue;
            }

            if (nums[leftPointer] == cachedNum) {
                cachedNumCount++;
                if (cachedNumCount > 2) {
                    // 向前移位
                    for (int i = leftPointer; i + 1 < nums.length; i++) {
                        nums[i] = nums[i + 1];
                    }
                    // 维护状态
                    actualLength--;
                    cachedNumCount--;
                    leftPointer--;
                }
            }

        }
        return actualLength;
    }


}
