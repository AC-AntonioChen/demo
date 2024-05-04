package hard;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Un_No_0003 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int leftPointer = 0;
        int rightPointer = 0;
        boolean firstEnter = true;
        while (rightPointer < s.length()) {
            if (firstEnter) {
                firstEnter = false;
            } else {
                set.remove(s.charAt(leftPointer));
                leftPointer++;
            }


            // 滑动窗口
            while (rightPointer < s.length() &&
                    !set.contains(s.charAt(rightPointer))) {
                set.add(s.charAt(rightPointer));
                rightPointer++;
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }

    @Test
    public void test() {
        String s = "abcabcdac";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
