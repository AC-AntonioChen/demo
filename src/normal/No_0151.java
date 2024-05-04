package normal;

import org.junit.Test;

import java.util.*;

public class No_0151 {
    @Test
    public void test() {
        System.out.println(reverseWords("a good    example"));
    }

    public String reverseWords(String s) {
        Deque<String> deque = new LinkedList<>();

        boolean isCountLetter = false;
        StringBuilder curWordSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (!isCountLetter) {
                // 之前还未遇到字母
                if (s.charAt(i) == ' ') {
                    continue;
                } else {
                    curWordSb.append(s.charAt(i));
                    isCountLetter = true;
                }
            } else {
                if (s.charAt(i) == ' ') {
                    if (curWordSb.length() > 0) {
                        deque.push(curWordSb.toString());
                        curWordSb.delete(0, curWordSb.length());
                    }
                } else {
                    curWordSb.append(s.charAt(i));
                }
            }
        }

        // 处理最后一个单词
        if (curWordSb.length() > 0) {
            deque.push(curWordSb.toString());
        }

        StringBuilder retSb = new StringBuilder();
        while (!deque.isEmpty()) {
            retSb.append(deque.pop());
            if (!deque.isEmpty()) {
                retSb.append(" ");
            }
        }
        return retSb.toString();
    }
}
