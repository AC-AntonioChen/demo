package extraclass;

import java.util.*;

/**
 * 随机化集
 *
 * @author CatCatHead
 * @date 2024/02/26
 */
public class RandomizedSet {
    private static final int MAX_ALLOWED_ARRAY_SIZE = 200000;
    private int[] inputNums;
    int curIndex = -1;

        /**
         * input值 - nums下标
         */
        Map<Integer, Integer> map;

    public RandomizedSet() {
        inputNums = new int[MAX_ALLOWED_ARRAY_SIZE];
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            curIndex++;
            inputNums[curIndex] = val;

            map.put(val, curIndex);
        }
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int deleteIndex = map.get(val);
            // 将要删除的元素和数组末尾元素换位
            inputNums[deleteIndex] = inputNums[curIndex];
            // 删除后 更新map状态
            map.put(inputNums[deleteIndex],deleteIndex);

            curIndex--;

            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return inputNums[new Random().nextInt(curIndex + 1)];
    }

        public static void main(String[] args) {
                RandomizedSet randomizedSet = new RandomizedSet();
                randomizedSet.insert(0);
                randomizedSet.insert(1);
                randomizedSet.remove(0);
                randomizedSet.insert(2);
                randomizedSet.remove(1);
                System.out.println(randomizedSet.getRandom());

        }
}