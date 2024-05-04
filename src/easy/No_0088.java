package easy;

import org.junit.Test;

import java.util.Arrays;

public class No_0088 {
//    暴力
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int curIndex = 0;
//        for (int i = m; i < nums1.length; i++) {
//            nums1[i] = nums2[curIndex];
//            curIndex++;
//        }
//        Arrays.sort(nums1);
//    }

    //    双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1Pointer = 0;
        int n2Pointer = 0;
        int[] resultArray = new int[m + n];
        int curIndex = 0;
        while (n1Pointer < m || n2Pointer < n) {
            if (n1Pointer >= m) {
                resultArray[curIndex] = nums2[n2Pointer];
                curIndex++;
                n2Pointer++;
                continue;
            }
            if (n2Pointer >= n) {
                resultArray[curIndex] = nums1[n1Pointer];
                curIndex++;
                n1Pointer++;
                continue;
            }
            if (nums1[n1Pointer] <= nums2[n2Pointer]) {
                resultArray[curIndex] = nums1[n1Pointer];
                n1Pointer++;
            } else {
                resultArray[curIndex] = nums2[n2Pointer];
                n2Pointer++;
            }
            curIndex++;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = resultArray[i];
        }
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
