package normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author CatCatHead
 * @version 1.0
 * @since 1.0.0
 */
public class No_0036 {
    //    board.length == 9
    //    board[i].length == 9
    //    board[i][j] 是一位数字（1-9）或者 '.'
    public boolean isValidSudoku(char[][] board) {
        //1、 遍历每一行
        Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Character>> columnMap = new HashMap<>();
        Map<Integer, HashSet<Character>> blockMap = new HashMap<>();
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int colIndex = 0; colIndex < board[rowIndex].length; colIndex++) {
                if (board[rowIndex][colIndex] == '.') {
                    continue;
                }
                if (isDuplicated(rowMap, rowIndex, board[rowIndex][colIndex])) {
                    return false;
                }
                if (isDuplicated(columnMap, colIndex, board[rowIndex][colIndex])) {
                    return false;
                }
                if (isDuplicated(blockMap, calBlockCode(rowIndex, colIndex), board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isDuplicated(Map<Integer, HashSet<Character>> columnMap, int colIndex, char c) {
        if (!columnMap.containsKey(colIndex)) {
            HashSet<Character> set = new HashSet<>();
            set.add(c);
            columnMap.put(colIndex, set);
        } else {
            if (columnMap.get(colIndex).contains(c)) {
                return true;
            } else {
                columnMap.get(colIndex).add(c);
            }
        }
        return false;
    }

    private int calBlockCode(int rowIndex, int columnIndex) {
        int baseStartIndex = (rowIndex / 3) * 3;
        if (columnIndex >= 0 && columnIndex < 3) {
            return baseStartIndex;
        } else if (columnIndex >= 3 && columnIndex < 6) {
            return baseStartIndex + 1;
        } else {
            return baseStartIndex + 2;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        No_0036 cls = new No_0036();
        boolean ret = cls.isValidSudoku(board);
        System.out.println(ret);
    }
}
