package easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 编号0058
 *
 * @author CatCatHead
 * @date 2024/04/14
 */
public class No_0058 {


    //
    public int lengthOfLastWord(String s) {
        boolean isCountLetter = false;
        int resultCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(!isCountLetter){
                if(s.charAt(i)==' '){
                    continue;
                } else {
                    resultCount++;
                    isCountLetter = true;
                }
            } else {
                if(s.charAt(i)==' '){
                    return resultCount;
                } else {
                    resultCount++;
                }
            }
        }
        return resultCount;
    }

    @Test
    public void test() {
        int i = lengthOfLastWord("hello world ");
        System.out.println(i);
    }
}
