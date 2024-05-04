package normal;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class No_0189 {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }

    // 数学解
    private void rotate(int[] nums, int k) {
        // 需要移动的数量
        int index = k % nums.length;
        int increment = nums.length - index;
        int[] clonedNums = new int[nums.length];
        // 注意要深拷贝
        System.arraycopy(nums, 0, clonedNums, 0, clonedNums.length);
        // n[0] = cn [4]; n[1] = cn[5]; n[2] =cn[6]; n[3]=cn[0]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = clonedNums[(i + increment) % nums.length];
        }
    }

    // 模拟解
    public void rotateOld(int[] nums, int k) {
        // 双向队列
        Deque<Integer> deque = new LinkedList<>();
        // init
        for (int num : nums) {
            deque.addFirst(num);
        }
        for (int i = 0; i < k; i++) {
            deque.addLast(deque.pollFirst());
        }
        int curIndex = 0;
        while (!deque.isEmpty()) {
            nums[curIndex] = deque.pollLast();
            curIndex++;
        }
        System.out.println(Arrays.toString(nums));
    }


}
