package easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No_0013 {

    //        罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
//        字符          数值
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
    @Test
    public void test() {
        System.out.println(romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        char lastChar = ' ';
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char curChar = s.charAt(i);
            if (i != s.length() - 1) {
                if (romanToIntMap.get(curChar) < romanToIntMap.get(lastChar)) {
                    // 改变计数方式为减法
                    result = result - romanToIntMap.get(curChar);
                } else {
                    result = result + romanToIntMap.get(curChar);
                }
            } else {
                result = result + romanToIntMap.get(curChar);
            }
            lastChar = curChar;
        }
        return result;
    }
}
