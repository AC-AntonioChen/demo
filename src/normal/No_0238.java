package normal;

import org.junit.Test;

import java.util.Arrays;

/**
 * 第0238号
 *
 * @author CatCatHead
 * @date 2024/02/29
 */
public class No_0238 {
    public int[] productExceptSelf(int[] nums) {
        // 左侧乘积前缀和
        int[] prefixProductNums = new int[nums.length + 2];
        // 右侧乘积前缀和
        int[] suffixProductNums = new int[nums.length + 2];

        // init
        prefixProductNums[0] = 1;
        prefixProductNums[prefixProductNums.length - 1] = 1;
        suffixProductNums[0] = 1;
        suffixProductNums[suffixProductNums.length - 1] = 1;

        // 计算前缀和
        for (int i = 0; i < nums.length; i++) {
            prefixProductNums[i + 1] = prefixProductNums[i] * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProductNums[i + 1] = suffixProductNums[i + 2] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixProductNums[i] * suffixProductNums[i + 2];
        }
        return nums;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        productExceptSelf(nums);
        System.out.println(Arrays.toString(nums));
    }
}
