package demo.javaguide.java.buctet.bucket;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶式排序
 *
 * @author CatCatHead
 * @date 2024/03/05
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = {1, 8, 7, 44, 42, 46, 38, 34, 33, 17, 15, 16, 27, 28, 24};
        List<Integer>[] buckets = new ArrayList[5];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < a.length; i++) {
            int index = a[i] / 10;
            buckets[index].add(a[i]);
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort(null);
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }
}
