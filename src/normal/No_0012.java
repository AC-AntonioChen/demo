package normal;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No_0012 {
//    字符          数值
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    @Test
    public void test() {
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        Map<Integer, String> intToRomanMap = new HashMap<>();
        intToRomanMap.put(1, "I");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(1000, "M");
        // 从左到右 1904 1000+(500+400)+00+4
        String numString = String.valueOf(num);


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numString.length(); i++) {
            // 1000,100,10,1
            int multiplier = (int) Math.pow(10, (numString.length() - i));

            int curValue = Integer.valueOf(String.valueOf(numString.charAt(i)));
            System.out.println(curValue);
        }
        return "s";
    }
}
