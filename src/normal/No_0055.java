package normal;

import org.junit.Test;

public class No_0055 {
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    // 贪心
    //    时间复杂度：O(n)O(n)O(n)，其中 nnn 为数组的大小。只需要访问 nums 数组一遍，共 nnn 个位置。
    //    空间复杂度：O(1)O(1)O(1)，不需要额外的空间开销。

    public boolean canJump(int[] nums) {
        int curIndex = 0;
        while (curIndex < nums.length) {
            // 无法继续跳跃
            if (nums[curIndex] == 0) {
                return false;
            }
            int bestJumpIndex = curIndex;
            int bestJumpScale = -1;
            for (int i = curIndex; i <= curIndex + nums[curIndex]; i++) {
                // success
                if (i + nums[i] >= nums.length - 1) {
                    return true;
                }
                // choose best
                if (i + nums[i] >= bestJumpScale) {
                    bestJumpScale = i + nums[i];
                    bestJumpIndex = i;
                }
            }
            curIndex = bestJumpIndex;
        }
        return true;
    }
}
