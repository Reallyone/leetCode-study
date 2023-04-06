package com.strom.study.面试题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class let_str_demo {

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     */
    public static boolean isUnique(String astr) {
        final char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            final char aChar = chars[i];
            if (aChar == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        final char[] chars1 = s1.toCharArray();
        final char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *
     * @param S
     * @param length
     * @return
     */
    public static String replaceSpaces(String S, int length) {

        StringBuilder stringBuilder = new StringBuilder();
        //逐渐遍历字符串
        for (int i = 0; i < length; i++) {
            //如果不是空格就加入到StringBuilder中，如果是空格
            //就把"%20"加入到StringBuilder中
            char ch = S.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * <p>
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * <p>
     * 回文串不一定是字典当中的单词。
     *
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome(String s) {
        Set<Character> sets = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!sets.add(chars[i])) {
                sets.remove(chars[i]);
            }
        }
        //最后判断set的长度是否小于等于1，如果等于1说明
        //只有一个字符的个数是奇数，其他的都是偶数。如果
        //等于0说明每个字符都是偶数，否则不可能构成回文字符串
        return sets.size() <= 1;
    }

    /**
     * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int len = first.length() - second.length();
        //如果大于1 或者小于-1 说明需要执行多次
        if (len > 1 || len < -1) {
            return false;
        }
        int count = 1;
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (len == 1) {
                    j--;
                } else if (len == -1) {
                    i--;
                }
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     * @param S
     * @return
     */
    public static String compressString(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        char[] chars = S.toCharArray();

        StringBuffer sb = new StringBuffer();

        int count = 1;
        char ch = chars[0];
        for (int i = 1; i < S.length(); i++) {
            if (ch == S.charAt(i)) {
                count++;
            } else {
                sb.append(ch);
                sb.append(count);
                ch = S.charAt(i);
                count = 1;
            }
        }
        //这里在append的是因为上面循环结束后，最后一组没有加上
        sb.append(ch);
        sb.append(count);
        return sb.length() >= S.length() ? S : sb.toString();
    }

    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] new_matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                new_matrix[j][n - i - 1] = matrix[i][j];
            }
        }
        System.out.println("a:" + Arrays.deepToString(new_matrix));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = new_matrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }


}
