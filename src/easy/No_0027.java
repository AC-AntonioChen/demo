package easy;

import org.junit.Test;

public class No_0027 {


    public int removeElement(int[] nums, int val) {
        int curIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == val && curIndex >= i) {
                nums[i] = nums[curIndex];
                curIndex--;
            }
        }
        return curIndex + 1;
    }


    @Test
    public void test() {

    }
}
