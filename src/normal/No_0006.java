package normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_0006 {
    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        //"PAHNAPLSIIGYIR"
        System.out.println(convert1(s, numRows));
    }


    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int axisLength = (2 * (numRows - 2) + 2);
        for (int curRow = 0; curRow < numRows; curRow++) {
            // 初始化指针起点，指向本行第一个字符位置
            int curIndex = curRow;
            while (curIndex < s.length()) {
                sb.append(s.charAt(curIndex));
                if (curRow == 0 || curRow == numRows - 1) {
                    curIndex = curIndex + axisLength;
                } else {
                    if (curIndex % axisLength < numRows) {
                        // 在竖轴上
                        curIndex = curIndex + (2 * (numRows - 2 - curRow) + 2);
                    } else {
                        // 在斜边上
                        curIndex = curIndex + (2 * (curRow - 1) + 2);
                    }
                }
            }
        }
        return sb.toString();
    }


    public String convert1(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


}
