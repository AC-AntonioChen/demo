package easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 编号0026
 *
 * @author CatCatHead
 * @date 2024/02/25
 */
public class No_0026 {
    @Test
    public void test() {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    // 双指针
    public int removeDuplicates(int[] nums) {
        // init
        int leftPointer = 0;
        int rightPointer = 1;
        // 遍历
        while (rightPointer < nums.length) {
            if (nums[leftPointer] == nums[rightPointer]) {
                rightPointer++;
                continue;
            } else {
                leftPointer++;
                nums[leftPointer] = nums[rightPointer];
            }
        }
        return leftPointer + 1;
    }
}
