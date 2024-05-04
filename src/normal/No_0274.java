package normal;

import org.junit.Test;

import java.util.Arrays;

/**
 * 正在工作0274
 *
 * @author CatCatHead
 * @date 2024/02/26
 */
public class No_0274 {
    @Test
    public void test() {
        int[] nums = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex(nums));

    }

    // 暴力解法
    public int hIndex(int[] citations) {
        int maxHIndex = -1;
        // how to sort array reversed order with basic type
        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            int curRange = citations.length - i;
            int curHIndex = Math.min(curRange, citations[i]);
            if (curHIndex < maxHIndex) {
                return maxHIndex;
            }
            maxHIndex = curHIndex;
        }
        return maxHIndex;
    }
}
