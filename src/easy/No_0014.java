package easy;

import org.junit.Test;


/**
 * 编号0058
 *
 * @author CatCatHead
 * @date 2024/04/14
 */
public class No_0014 {


    //
    public String longestCommonPrefix(String[] strs) {
        int strLength = strs[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            char curChar = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() < i + 1 || curChar != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(curChar);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
