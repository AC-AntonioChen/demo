package normal;

import org.junit.Test;

/**
 * 工作编号0045
 *
 * @author CatCatHead
 * @date 2024/02/25
 */
public class No_0045 {
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    // 题目保证可以到达 nums[n-1]
    public int jump(int[] nums) {
        int stepCount = 0;
        int curIndex = 0;
        // 进行本次跳跃
        while (curIndex < nums.length - 1) {
            stepCount++;

            // jump to final index success
            if (curIndex + nums[curIndex] >= nums.length - 1) {
                return stepCount;
            }

            // record best index and max jump scale
            int bestJumpIndex = curIndex;
            int bestJumpScale = -1;

            for (int i = curIndex; i <= curIndex + nums[curIndex]; i++) {
                if (curIndex > nums.length - 1) {
                    break;
                }
                // choose best
                if (i + nums[i] >= bestJumpScale) {
                    bestJumpScale = i + nums[i];
                    bestJumpIndex = i;
                }
            }
            curIndex = bestJumpIndex;
        }
        return stepCount;
    }
}
